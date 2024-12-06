package org.sber;

public interface PhotoService {
    Photo findPhotoById(String id);

    boolean savePhoto(Photo photo);
}
