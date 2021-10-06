/********************************************************
 * Basic Code to demo LED Controller
 * 
 * By: James Taylor
 * Since: 2020-03-09
 * 
 * TO Download
 * 
 *     * Set Board to Arduino Zero Native Port
 *     * You might need to download Arduino SAMD boards
 *     * in boards manager
 *     * Tested on SAMD Boards V1.8.4
 *     * The Dotstar and Neopixel library are also
 *     * required and can be downloaded in library
 *     * manager 
 *     * Dotstar V1.1.3
 *     * Neopixel V1.3.4
 *     
 *  You also might need to run Arduino as admin to upload
 *  code to the board.
 * 
 *  This sketch takes up 5% of space, so its possible for
 *  some crazy shenanigans with this controller
 *******************************************************/

#define DOTSTAR 1
#define NEOPIXEL 2

//Comment or uncomment based on strip used
#define LEDTYPE DOTSTAR
//#define LEDTYPE NEOPIXEL

#define STRIP1_DATAPIN 9
#define STRIP1_CLOCKPIN 6 
#define STRIP2_DATAPIN 5
#define STRIP2_CLOCKPIN 3

int BRIGHTNESS = 60; // Range (1-255)
int LED_COUNT1 = 9; // Strip 1 LED Count
int LED_COUNT2 = 9; // Strip 2 LED Count

#if LEDTYPE == DOTSTAR
  #include <Adafruit_DotStar.h>
  #include <SPI.h>
  Adafruit_DotStar strip1 = Adafruit_DotStar(LED_COUNT1, STRIP1_DATAPIN, STRIP1_CLOCKPIN, DOTSTAR_BRG);
  Adafruit_DotStar strip2 = Adafruit_DotStar(LED_COUNT2, STRIP2_DATAPIN, STRIP2_CLOCKPIN, DOTSTAR_BRG);
#endif
#if LEDTYPE == NEOPIXEL
  #include <Adafruit_NeoPixel.h>
  Adafruit_NeoPixel strip1(LED_COUNT1, STRIP1_DATAPIN, NEO_GRB + NEO_KHZ800);
  Adafruit_NeoPixel strip2(LED_COUNT2, STRIP2_DATAPIN, NEO_GRB + NEO_KHZ800);
#endif

void setup()
{
  strip1.begin();
  strip2.begin();
  strip1.show();
  strip2.show();
  strip1.setBrightness(BRIGHTNESS);
  strip2.setBrightness(BRIGHTNESS);
}

void loop() {
  theaterChaseRainbow(50); // Strip 1
  rainbow(10); // Strip 2
}

void theaterChaseRainbow(int wait) {
  int firstPixelHue = 0;     // First pixel starts at red (hue 0)
  for(int a=0; a<30; a++) {  // Repeat 30 times...
    for(int b=0; b<3; b++) { //  'b' counts from 0 to 2...
      strip1.clear();         //   Set all pixels in RAM to 0 (off)
      strip2.clear();
      // 'c' counts up from 'b' to end of strip in increments of 3...
      for(int c=b; c<strip1.numPixels(); c += 3) {
        // hue of pixel 'c' is offset by an amount to make one full
        // revolution of the color wheel (range 65536) along the length
        // of the strip (strip.numPixels() steps):
        int      hue   = firstPixelHue + c * 65536L / strip1.numPixels();
        uint32_t color = strip1.gamma32(strip1.ColorHSV(hue)); // hue -> RGB
        strip1.setPixelColor(c, color); // Set pixel 'c' to value 'color'
        strip2.setPixelColor(c, color);
      }
      strip1.show();                // Update strip with new contents
      strip2.show();
      delay(wait);                 // Pause for a moment
      firstPixelHue += 65536 / 90; // One cycle of color wheel over 90 frames
    }
  }
}

// Rainbow cycle along whole strip. Pass delay time (in ms) between frames.
void rainbow(int wait) {
  // Hue of first pixel runs 5 complete loops through the color wheel.
  // Color wheel has a range of 65536 but it's OK if we roll over, so
  // just count from 0 to 5*65536. Adding 256 to firstPixelHue each time
  // means we'll make 5*65536/256 = 1280 passes through this outer loop:
  for(long firstPixelHue = 0; firstPixelHue < 5*65536; firstPixelHue += 256) {
    for(int i=0; i<strip2.numPixels(); i++) { // For each pixel in strip...
      // Offset pixel hue by an amount to make one full revolution of the
      // color wheel (range of 65536) along the length of the strip
      // (strip.numPixels() steps):
      int pixelHue = firstPixelHue + (i * 65536L / strip2.numPixels());
      // strip.ColorHSV() can take 1 or 3 arguments: a hue (0 to 65535) or
      // optionally add saturation and value (brightness) (each 0 to 255).
      // Here we're using just the single-argument hue variant. The result
      // is passed through strip.gamma32() to provide 'truer' colors
      // before assigning to each pixel:
      strip2.setPixelColor(i, strip2.gamma32(strip2.ColorHSV(pixelHue)));
      strip1.setPixelColor(i, strip1.gamma32(strip1.ColorHSV(pixelHue)));
    }
    strip2.show(); // Update strip with new contents
    strip1.show();
    delay(wait);  // Pause for a moment
  }
}
