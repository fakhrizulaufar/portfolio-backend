package com.store.games.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GameRequest {

    @NotBlank(message = "Title tidak boleh kosong")
    private String title;

    private String genre;

    @Min(value = 1, message = "Harga minimal 1")
    private int price;

    @Min(value = 0, message = "Stock tidak boleh negatif")
    private int stock;
}
