 int birdx= 0;
 int birdy= 0;
 int birdYVelocity = 12;
  int gravity = 5;
  int pipex = 600;
  
  int upperPipeHeight = 250;
  int lowerPipeHeight = 250;
  int gap = 45;
  void teleportpipe(){
    pipex=600;
     upperPipeHeight = (int) random(100, 400);

  
  }
void setup(){
  size(600,600);
  stroke(145,0,0);
}
void draw(){
  pipex -=2;
  if(mousePressed){
   birdy-=birdYVelocity; 
   if(birdy < 8){
    birdy = 8; 
   }
  }
  background(200,200,200);
  fill(225,0,0);
  ellipse(birdx,birdy,25,15);
  birdx=300;
  birdy +=gravity;
if (birdy>height-8){
    birdy = 592; 
  }
  fill(14,135,4);
rect(pipex,0,40,upperPipeHeight);
rect(pipex,600,40, gap - upperPipeHeight );
if(pipex == 0){
  teleportpipe();
}
}