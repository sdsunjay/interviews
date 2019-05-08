public class Circle extends Shape{
  // area = pi * r^2
  double radius = 0;
  public Circle(double radius){
    if(radius <= 0){
      throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
    }
    this.radius = radius;
  }
  public double get_area(){
    return Math.PI * (radius * radius);
  }
  public void draw(Object object, int x, int y){
    if(object instanceof Gd){
      Gd gd = (Gd) object;
      gd.gd_circle(x, y, radius);
    }
    else if(object instanceof ImageMagick){
      ImageMagick im = (ImageMagick) object;
      im.drawArc(y, x, radius, 0);
    }
  }
}
