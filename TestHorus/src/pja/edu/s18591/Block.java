package pja.edu.s18591;

class Block implements  IBlock{

    String color;
    String material;

    @Override
    public String toString() {
        return "Block{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public Block(String color, String material) throws EmptyException {
        setColor(color);
        setMaterial(material);
    }

    public void setColor(String color) throws EmptyException {
        if(color == null || color.isBlank()){
            throw new EmptyException("Color could not be null");
        }
        this.color = color;
    }

    public void setMaterial(String material) throws EmptyException {
        if(material == null || material.isBlank() ){
            throw new EmptyException("Color could not be null");
        }
        this.material = material;
    }
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
