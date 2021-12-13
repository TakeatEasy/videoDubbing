package com.huiji.video_dubbing.service;

import java.io.InputStream;

public interface IObjectSaveService {

    String saveObject(InputStream inputStream, String fileName);

    String saveMusic(InputStream inputStream, String fileName);

    String saveVideo(InputStream inputStream, String fileName);
}
