# -*- coding: utf-8 -*-
"""
Created on Mon Feb 3 11:54:06 2020
@author: twilkinson
"""
from flask import Flask, request
from werkzeug.utils import secure_filename
app = Flask(__name__)
VIDEOS_FOLDER = '/users/twilkinson/Downloads/ASLClassifyApp/app/Recordings/'

@app.route('/uploader' , methods=['GET' , 'POST'])
def upload_file():    
      try:
        if request.method == 'POST':
            f = request.files['uploaded_file']
            f.save(VIDEOS_FOLDER + secure_filename(f.filename))
            return 'file uploaded successfully'
      except Exception as e:
        print("Exception while running __fit_model()" + str(e))
        raise e
        
if __name__ == '__main__':
      app.run(host = "0.0.0.0", port = 5000, debug=True)
