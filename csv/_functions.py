import csv
import json
from _config import Config as cfg


def getJson(path):
    """"returns the json at the given path as a dict"""
    with open(path, "r") as f:
        data = json.load(f)
    return data

def getJsonElements():
    """get the elements.json"""
    return getJson(cfg.PATH_ELEMENT)["elements"]

def getJsonCompounds():
    """get the compounds.json"""
    return getJson(cfg.PATH_COMPOUND)["compounds"]

def getCsv(path, base):
    """returns the csv at the given path as a dict"""
    def conv(entry):
        if "atomic_number" in entry.keys():
            entry["atomic_number"] = int(entry["atomic_number"])
        if "components" in entry.keys():
            entry["components"] = json.loads(entry["components"].replace("'",'"'))
        if "has_item" in entry.keys():
            if entry["has_item"] == "True":
                entry["has_item"] = True
            else:
                entry["has_item"] = False
        return entry

    text = {base : []}
    with open(path, "r") as csv_file:
        data = csv.DictReader(csv_file)
        for row in data:
            text[base].append(conv(row))
    return text

def getCsvElements():
    """get the elements.csv"""
    return getCsv(cfg.CSV_ELEMENT, cfg.FILE_ELEMENT)

def getCsvCompounds():
    """get the compounds.csv"""
    return getCsv(cfg.CSV_COMPOUND, cfg.FILE_COMPOUND)

def writeCsv(file, fields, data):
    """writes the fiven data to the given csv file using the given fields"""
    with open(file, "w+") as csv_file:
        writer = csv.DictWriter(csv_file, fieldnames=fields)
        writer.writeheader()
        writer.writerows(data)

def writeJson(file, data):
    """writes the given data to the given json file"""
    with open(file, "w+") as f:
        json.dump(data, f, indent=2)

def c2CSV_Elements():
    """converts the elements.json to an elements.csv file"""
    writeCsv(cfg.CSV_ELEMENT, cfg.FIELDS_ELEMENT, getJsonElements())

def c2CSV_Compounds():
    """converts the compounds.json to a compounds.csv file"""
    writeCsv(cfg.CSV_COMPOUND, cfg.FIELDS_COMPOUND, getJsonCompounds())

def c2JSON_Elements():
    """converts the elements.csv to an elements.json file"""
    writeJson(cfg.JSON_ELEMENT, getCsvElements())

def c2JSON_Compounds():
    """converts the compounds.csv to a compounds.json file"""
    writeJson(cfg.JSON_COMPOUND, getCsvCompounds())
