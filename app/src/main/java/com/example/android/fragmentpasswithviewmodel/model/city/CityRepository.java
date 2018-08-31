package com.example.android.fragmentpasswithviewmodel.model.city;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.fragmentpasswithviewmodel.data.city.CityRoomDatabase;
import com.example.android.fragmentpasswithviewmodel.service.CityDao;

import java.util.List;

public class CityRepository {

    /**Define cities Dao*/
    private CityDao mCityDao;
    /**Live Data of List of all cities*/
    private LiveData<List<City>> mAllCities;

    /**City repository*/
    public CityRepository(Application application) {
        CityRoomDatabase db = CityRoomDatabase.getDatabase(application);
        /**init Cities Dao*/
        mCityDao = db.cityDao();
        /**get all cities*/
        mAllCities = mCityDao.getAllCities();
    }
    /**method to get all cities*/
    public LiveData<List<City>> getAllCities() {
        return mAllCities;
    }
    /**method to add a city*/
    public void insert (City city) {
        new insertAsyncTask(mCityDao).execute(city);
    }

    /**Async task to add a city*/
    private static class insertAsyncTask extends AsyncTask<City, Void, Void> {

        private CityDao mAsyncTaskDao;

        insertAsyncTask(CityDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final City... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**Async task to delete all cities*/
    private static class deleteAllCitiesAsyncTask extends AsyncTask<Void, Void, Void> {
        private CityDao mAsyncTaskDao;

        deleteAllCitiesAsyncTask(CityDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**method to delete all cities*/
    public void deleteAll()  {
        new deleteAllCitiesAsyncTask(mCityDao).execute();
    }

    /**Async task to delete a city*/
    private static class deleteCityAsyncTask extends AsyncTask<City, Void, Void> {
        private CityDao mAsyncTaskDao;

        deleteCityAsyncTask(CityDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final City... params) {
            mAsyncTaskDao.deleteCity(params[0]);
            return null;
        }
    }

    /**method to delete a city*/
    public void deleteCity(City city) {
        new deleteCityAsyncTask(mCityDao).execute(city);
    }


}
