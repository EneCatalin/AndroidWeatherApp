package com.example.android.fragmentpasswithviewmodel.model.city;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.android.fragmentpasswithviewmodel.data.city.CityRoomDatabase;
import com.example.android.fragmentpasswithviewmodel.service.CityDao;

import java.util.List;

public class CityRepository {

    private CityDao mCityDao;
    private LiveData<List<City>> mAllCities;

    public CityRepository(Application application) {
        CityRoomDatabase db = CityRoomDatabase.getDatabase(application);
        mCityDao = db.cityDao();
        mAllCities = mCityDao.getAllCities();
    }
    public LiveData<List<City>> getAllCities() {
        return mAllCities;
    }

    public void insert (City city) {
        new insertAsyncTask(mCityDao).execute(city);
    }

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

    public void deleteAll()  {
        new deleteAllCitiesAsyncTask(mCityDao).execute();
    }


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

    public void deleteCity(City city) {
        new deleteCityAsyncTask(mCityDao).execute(city);
    }


}
