import sys
import time
import datetime
import gspread
import oauth2client.client
import json
import os
import argparse

from oauth2client.service_account import ServiceAccountCredentials

import httplib2
from oauth2client import client

#json filename for credentials
JSON = 'leafy.json'
json_key = json.load(open(JSON))

scope = ['https://spreadsheets.google.com/feeds','https://www.googleapis.com/auth/drive']
creds = ServiceAccountCredentials.from_json_keyfile_name('leafy.json', scope)
client = gspread.authorize (creds)

sheet = client.open('Results_Raspberry_Pi').sheet1

num = sheet.get_all_values()
x = len(num) -1

while x>0:
    if (num[x][2]=="January") & (num[x][3] == "Monday") & (num[x][4]=="0:00"):
        result=num[x][0]
        break
    x= x-1
print(result)