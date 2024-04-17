from flask import Flask, request, jsonify
import time
import psutil
import tracemalloc
import threading
# import pyRAPL
from codecarbon import EmissionsTracker
import requests

app = Flask(__name__)



def memory(arr):
    time.sleep(5)
    arr.append(psutil.virtual_memory().used)

def response(obj,url,res):
    res.append(requests.post(url, json=obj))


# Define the endpoint /getResponse
@app.route('/getResponse', methods=['POST'])
def get_response():
    try:
        data = request.get_json()
        # Validate 'data' for required fields

        # Construct request object for model generation
        url = 'http://localhost:11434/api/generate'
        myobj = {
            "model": data['model']['name'],
            "prompt": data['prompt'],
            "stream": False
        }
        print(myobj)
        # Start measurement using pyRAPL for energy consumption
        # pyRAPL.setup()
        tracker = EmissionsTracker()
        # meter = pyRAPL.Measurement('bar')
        # meter.begin()
        tracker.start()
        # record start time
        start_time = time.time()

        start_memory = psutil.virtual_memory().used
        # Measure CPU usage before sending the request
        cpu_usage_before = psutil.cpu_percent(interval=1)

        # Send POST request to generate model response
        tracemalloc.start()
        # print('Start RAM Used (GB):', start_memory / 1000000000)
        # first_size, first_peak = tracemalloc.get_traced_memory()
        arr = [start_memory]
        res= []
        t1 = threading.Thread(target=response, args=(myobj,url,res))
        t2 = threading.Thread(target=memory, args=(arr,))

        t1.start()
        t2.start()

        t1.join()
        t2.join()
        # x = requests.post(url, json=myobj)
        # second_size, second_peak = tracemalloc.get_traced_memory()
        # memory_usage = tracemalloc.get_traced_memory()
        # print(f"{first_size=}, {first_peak=}")
        # print(f"{second_size=}, {second_peak=}")
        # tracemalloc.stop()
        # print('Stop RAM Used (GB):', stop_memory / 1000000000)
        # stop_memory = psutil.Process().memory_info().rss
        print(arr[1], arr[0])
        memory_usage = arr[1] - arr[0]

        # Measure CPU usage and execution time after receiving the response
        # meter.end()
        emission = tracker.stop()
        cpu_usage_after = psutil.cpu_percent(interval=1)
        end_time = time.time()
        execution_time = end_time - start_time
        # energy_consumption = meter.result
        print(memory_usage)

        cpu_usage_change = cpu_usage_after - cpu_usage_before


        return {
            "memory_usage": memory_usage,
            "cpu_usage_change": cpu_usage_change,
            "response_time": round(execution_time,2),
            "result": res[0].json(),
            "energy": round(tracker.final_emissions_data.energy_consumed*1000,2)  # Placeholder for energy consumption (to be calculated or measured)
        }
    except Exception as e:
        app.logger.error(f"An error occurred: {str(e)}")
        return jsonify({"error": "An error occurred while processing the response"}), 500


@app.route('/getList', methods=['GET'])
def get_list():
    url = 'http://localhost:11434/api/tags'
    try:
        # Fetch and return the list of available models/tags
        x = requests.get(url)
        return x.json()
    except Exception as e:
        app.logger.error(f"An error occurred: {str(e)}")
        return jsonify({"error": "An error occurred while fetching and processing models list"}), 500


if __name__ == '__main__':
    app.run(debug=True)  # Run the Flask app
