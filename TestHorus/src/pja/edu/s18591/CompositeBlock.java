package pja.edu.s18591;

import pja.edu.s18591.Block;
import pja.edu.s18591.EmptyException;
import pja.edu.s18591.ICompositeBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CompositeBlock implements ICompositeBlock {
    String color;
    String material;
    List<Block> blockList = new ArrayList<Block>();

    public CompositeBlock(Block block) throws EmptyException {
        addBlock(block);
        setColor();
        setMaterial();
    }

    public void setColor()  {
        this.color = blockList.get(0).getColor();
    }

    public void setMaterial() {
        this.material = blockList.get(0).getMaterial();
    }

    @Override
    public String toString() {
        return "CompositeBlock{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", blockList=" + blockList +
                '}';
    }

    public void addBlock(Block block) throws EmptyException {
        if(block == null){
            throw new EmptyException("Block could not be null");
        }
        if(blockList.size() != 0){
            if(block.getColor() != this.getColor()){
                throw new EmptyException("You need use block with the same color: " + this.getColor());
            }
        }
        blockList.add(block);
    }
    public void removeBlock(Block block) throws EmptyException {
        if(block == null){
            throw new EmptyException("Block could not be empty");
        }if (blockList.size() == 1){
            return;
        }
        blockList.remove(block);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial(){
        return material;
    }

    @Override
    public List getBlocks() {
        return Collections.unmodifiableList(blockList);
    }

}
