package com.docdoku.simple_form_application.data

import com.docdoku.simple_form_application.data.api.IDogApi
import com.docdoku.simple_form_application.data.api.IUserApi
import com.docdoku.simple_form_application.data.db.IDogDbHelper


interface IDataManager : IDogApi, IDogDbHelper, IUserApi