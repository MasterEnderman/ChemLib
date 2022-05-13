class Config:
    FILE_ELEMENT = "elements"
    FILE_COMPOUND = "compounds"

    CSV_ELEMENT = f"./csv/import/{FILE_ELEMENT}.csv"
    CSV_COMPOUND = f"./csv/import/{FILE_COMPOUND}.csv"

    JSON_ELEMENT = f"./csv/export/{FILE_ELEMENT}.json"
    JSON_COMPOUND = f"./csv/export/{FILE_COMPOUND}.json"

    PATH_ELEMENT = f"./src/main/resources/data/chemlib/{FILE_ELEMENT}.json"
    PATH_COMPOUND = f"./src/main/resources/data/chemlib/{FILE_COMPOUND}.json"

    FIELDS_ELEMENT = [ "name","atomic_number","abbreviation","matter_state","metal_type","has_item","description","color" ]
    FIELDS_COMPOUND = [ "name","matter_state","has_item","description","color","components" ]
