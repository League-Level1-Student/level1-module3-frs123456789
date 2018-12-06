int frogx = 200;
int frogy = 350;

void setup(){
  size(400,400);
  
  
}
void draw(){
  background(111, 247, 136);
  
  fill(255, 229, 0);
ellipse(frogx,frogy, 25, 25);
froggylimits();

car newcar = new car(carspeed,200);
car newcar1 = new car(100,300);
car newcar2 = new car(350,100);
car newcar3 = new car(50,50);
newcar1.display();
newcar2.display();
newcar3.display();
newcar.display();
}
void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                  frogy = frogy-10;
            }
            else if(keyCode == DOWN)
            {
                  frogy = frogy+10;
            }
            else if(keyCode == RIGHT)
            {
                  frogx = frogx+10;
            }
            else if(keyCode == LEFT)
            {
                  frogx = frogx-10;
            }
      }
}
void froggylimits(){
  if(frogx<5){
   frogx = 5; 
  }
  
  else if(frogx>395){
   frogx = 395; 
  }
  if(frogy<5){
   frogy = 5; 
  }
  else if(frogy>395){
   frogy=395; 
  }}
  class car{
    void speed(){
      int carspeed = 400;
      carspeed = carspeed -10;
      if(carspeed == 0){
       carspeed = 400; 
      }
    }
    int carx;
    int cary;
    void draw(){
    rect(carx, cary, 60,25);
  
    }
    car(int carx, int cary){
       this.carx = carx;
     this. cary = cary;
    }
    void display() 
{
      fill(0,255,0);
      rect(carx,cary, 60, 50);
}
  }