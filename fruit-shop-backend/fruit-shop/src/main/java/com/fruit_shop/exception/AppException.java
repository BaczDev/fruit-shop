package com.fruit_shop.exception;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException{
    private ErrorCode errorCode;
}
