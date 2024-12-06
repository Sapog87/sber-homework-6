package org.sber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Photo {
    private String id;
    private String description;
    private String path;
}
