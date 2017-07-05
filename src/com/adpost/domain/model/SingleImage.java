package com.adpost.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="single")
public class SingleImage extends AdPicture{
	
}
