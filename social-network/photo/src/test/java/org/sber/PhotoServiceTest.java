package org.sber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PhotoServiceTest {

    @Mock
    PhotoService photoService;

    @Test
    void findPhotoById() {
        //given
        doReturn(new Photo("0", "description", "path")).when(photoService).findPhotoById("0");

        //when
        Photo photo = photoService.findPhotoById("0");

        //then
        assertNotNull(photo);
        assertEquals("description", photo.getDescription());
    }

    @Test
    void savePhoto() {
        //given
        doReturn(true).when(photoService).savePhoto(any());

        //when
        boolean result = photoService.savePhoto(new Photo("0", "description", "path"));

        //then
        assertTrue(result);
    }
}