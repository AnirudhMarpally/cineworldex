package com.pkglobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MovieRequest {
	
	@NotNull(message = "Movie title shouldn't be null")
	private String title;
    private String description;
    @NotBlank(message = "Please enter the language")
    private String language;
    private String image;
    @NotBlank(message = "Genre is missing")
    private String genre;
    

}
