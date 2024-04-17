# Flask Model Generation API

This Flask application provides an API for generating model responses and fetching available models/tags from the Ollama.


## Pre-requisite
Before running this Flask API, ensure you have the following prerequisites:

- **Python 3.x**: Ensure Python 3.x is installed.
- **Ollama Service Installation**: Install the Ollama service by running the following command:
  ```bash
  curl https://ollama.ai/install.sh | sh
  ```

For more information on Ollama installation and reference, visit [Ollama GitHub repository.](https://github.com/jmorganca/ollama)
## Models
Following models are used to for the analysis:
1. falcon:40b
2. falcon:7b
3. llama2:13b
4. llama2:70b 
5. llama2:7b
6. vicuna:13b
7. vicuna:33b 
8. vicuna:7b 



## Installation

- Install the required dependencies using pip:

```bash
pip install flask pymongo psutil pandas codecarbon requests urllib3==1.26.6 tracemalloc  
```

## Run
You can run the backend folder for using below command:
- For local setup
```bash
flask --app ollama_flask.py run
```
- For hosting on server 
```bash
flask --app ollama_flask.py run -h hostname -p 5000
```

### Endpoints
1. `POST /getResponse`:** Generates a model response based on provided data.

        Method: POST
        curl --location 'http://127.0.0.1:5000/getResponse'
        Request Body:
            {
                "model": {
                "name": "falcon:7b"
                },
                "prompt": "Why is sky blue?"
            }
   Response

        {
            "cpu_usage_change": 0.0,
            "energy": 0.43,
            "memory_usage": 0.03780937194824219,
            "response_time": 13.122224807739258,
            "result": {
                "context": [193,7932,37,4161,304,7385,4172,42,193,44295,37,193,487,7385,5741,4172,
                           875,275,248,818,248,6490,18,94,8922,49960,335,17582,25,1699,17582,20866,248,6490,
                           18,94,8922,23,334,18,94,21878,272,455,11033,431,14670,606,8504,273,1391,24548,25,2050,1385,14670,39270,248,1547,273,717,334,
                           2301,4172,23,585,304,248,2460,275,1547,325,504,650,21878,248,758,25,193,7932,204,11
                            ],
                "created_at": "2023-12-10T09:48:20.981532505Z",
                "done": true,
                "eval_count": 69,
                "eval_duration": 9570285000,
                "load_duration": 586566,
                "model": "falcon:7b",
                "prompt_eval_count": 12,
                "prompt_eval_duration": 1529950000,
                "response": "The sky appears blue because of the way the Earth's atmosphere interacts with sunlight. When sunlight enters the Earth's atmosphere, it's scattered in all directions by particles like dust and water vapor. These small particles scatter the light and make it appear blue, which is the color of light that has been scattered the most.\nUser <|endoftext|>",
                "total_duration": 11105402610
    }
}
2. `GET /getList`: Fetches and returns a list of available models/tags.
        
           Method: GET
           curl --location 'http://127.0.0.1:5000/getList'
   Response

        {
            "models": [
                {
                    "digest": "bc9368437a24284c4dc3b9e3813d21162639ced55fc81a2830e39c17070f803a",
                    "modified_at": "2023-12-10T07:20:51.530363122Z",
                    "name": "falcon:40b",
                    "size": 23808463019
                },
                {
                    "digest": "4280f7257e73108cddb43de89eb9fa28350a21aaaf997b5935719f9de0281563",
                    "modified_at": "2023-12-10T07:13:41.255769386Z",
                    "name": "falcon:7b",
                    "size": 4210994570
                }
            ]
        }

Note: Ensure the server running the model generation API (http://localhost:11434) is accessible and functioning.

### Dependencies

* Flask: Web framework for building the API.
* psutil: Provides system and process utilities.
* tracemalloc: Allows tracing memory allocations.
* pyRAPL: Enables measuring energy consumption.
* requests: HTTP library for making requests.

