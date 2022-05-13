# CSV Converter for ChemLib

`csv2json.py` - convert the `elements.csv` and `compunds.csv` into json files that can be used by chemlib. (can be found in `./csv/export/`)
`json2csv` - grabs the `elements.json` and `compounds.json` from `./src/main/resources/data/chemlib/` and converts them into csv files. (can be found in `./csv/import/`)

`_config.py` - contains all the paths and file names.
`_functions.py` - contains all the functions used by `csv2json.py` and `json2csv.py`

I use [Visual Studio Code](https://code.visualstudio.com) in combination with [Edit csv](https://marketplace.visualstudio.com/items?itemName=janisdd.vscode-edit-csv) to display the csv files as simple excel like tables.
