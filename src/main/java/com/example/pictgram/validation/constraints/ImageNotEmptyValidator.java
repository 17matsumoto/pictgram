package com.example.pictgram.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author matsumotoyuyya
 *画像関連バリデータークラス.
 */
public class ImageNotEmptyValidator implements ConstraintValidator<ImageNotEmpty, MultipartFile> {

    @Override
    public void initialize(ImageNotEmpty annotation) {
    }

    /**
     *画像んが空であるか検証します.
     */
    @Override
    public boolean isValid(MultipartFile image, ConstraintValidatorContext context) {
        if (image.isEmpty()) {
            return false;
        }
        return true;
    }
}
