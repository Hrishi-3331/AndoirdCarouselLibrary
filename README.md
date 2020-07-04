[![](https://jitpack.io/v/Hrishi-3331/AndoirdCarouselLibrary.svg)](https://jitpack.io/#Hrishi-3331/AndoirdCarouselLibrary)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)


# AndoirdCarouselLibrary
Android Library for Carousels


Carousels are important elements of modern UI Designs. Here is easy to use open source library for implementing carousels in android activities.

## Carousel with bottom dots
<img src="https://user-images.githubusercontent.com/43084197/86379277-46687580-bca8-11ea-9748-e1538f33154e.jpeg" width="300">    <img src="https://user-images.githubusercontent.com/43084197/86378698-92ff8100-bca7-11ea-8f23-c38192e35cb6.jpeg" width="300">    <img src="https://user-images.githubusercontent.com/43084197/86379041-f4bfeb00-bca7-11ea-848b-8911dc7de4c0.jpeg" width="300">

## Carousel with overlaping dots
<img src="https://user-images.githubusercontent.com/43084197/86376552-c5f44580-bca4-11ea-857a-cf718dfbbc02.jpeg" width="300" style="margin:5px" >    <img src="https://user-images.githubusercontent.com/43084197/86376540-c12f9180-bca4-11ea-98e1-777bd663b18c.jpeg" width="300">    <img src="https://user-images.githubusercontent.com/43084197/86376547-c42a8200-bca4-11ea-8443-b1e23a81be65.jpeg" width="300">

### Installation

Follow these steps to use this library in your android project..

Step1 : Add it in your root build.gradle at the end of repositories:

```sh
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step2: Add the dependency in app level gradle file

```sh
dependencies {
    implementation 'com.github.Hrishi-3331:AndoirdCarouselLibrary:v1.0.0'
}
```

### User Guide

Methods:

Following methods can be used to customize  your carousel

* setLength() - Set the number of images in your carousel. Current version supports upto 8 carousels. This method is be mandatorily called after initialization of CarouselView.

* setColorActive() - Set the color of active dot. Default active color is red.

* ssetColorInActive() - Set the color of inactive dot. Default active color is blue.

* enableDots() - This method is use to enable dots view along with promotional images. Dots are enabled by default. This method can be used to re-enable them if they are disabled by some other method.

* disableDots() - This method is used to hide/disappear dots. Dots can be re-enabled again using enableDots().

* addPromotion() - Method used to add promotional image to carousel. If this method is called for more number of times than the length specified in setLength(), then the overflow is discarded.

* showCarousel() - This method is to be mandatorily called after initalization and configuration process. CarouselView is visible only after this method is called. Default visibility of view is VIEW.GONE

* overlapDotsonImage() - This method enables dots to overlap carousel images. But default overlapping is disabled and can be enabled by calling this method.






License
----

MIT


**Open Source! Contributions to project are always welcome**
