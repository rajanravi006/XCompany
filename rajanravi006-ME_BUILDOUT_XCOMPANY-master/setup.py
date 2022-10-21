import json
import sys

def change_language(file_path,language):
    with open(file_path, 'r') as f:
        data = json.load(f)
        data["module_language"] = language

    with open(file_path, 'w') as json_file:
        json.dump(data, json_file)
    



if __name__ == "__main__":
    change_language(sys.argv[1],sys.argv[2])


