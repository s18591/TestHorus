package pja.edu.s18591;

import pja.edu.s18591.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Wall implements Structure {
    private List<CompositeBlock> compositeBlocks = new ArrayList<>();

    public Wall(List<CompositeBlock> compositeBlocks) {
        this.compositeBlocks = compositeBlocks;
    }

    @Override
    public Optional findBlockByColor(String color) {
        Optional<CompositeBlock> block = compositeBlocks.stream().filter(e -> e.getColor().equals("red")).findAny();
        return block;
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List<CompositeBlock> outPut = new ArrayList<>();
        for (CompositeBlock block : compositeBlocks) {
            if(block.getMaterial().equals(material)){
               outPut.add(block);
            }
        }
        return outPut;
    }

    @Override
    public int count() {
        int outPut = 0;
        for (CompositeBlock block : compositeBlocks) {
            for(int i = 0; i<block.getBlocks().size(); i++) {
                outPut++;
            }
            }
        return compositeBlocks.size() + outPut;
    }
}