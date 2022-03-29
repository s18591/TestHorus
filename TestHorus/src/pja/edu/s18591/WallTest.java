package pja.edu.s18591;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    Block block;
    List<CompositeBlock> compositeBlocks;
    CompositeBlock compositeBlock;
    Wall wall;

    @BeforeEach
    void init() throws EmptyException {
        block = new Block("red","steel");
        compositeBlocks = new ArrayList<>();
        compositeBlock = new CompositeBlock(block);
        wall = new Wall(compositeBlocks);
        compositeBlocks.add(compositeBlock);
    }

    @org.junit.jupiter.api.Test
    void findBlockByColor() {
        assertTrue( wall.findBlockByColor("red").isPresent());
    }

    @org.junit.jupiter.api.Test
    void findBlocksByMaterial() {
        assertEquals(wall.findBlocksByMaterial("steel").size(),1);
        assertTrue(wall.findBlocksByMaterial("steel").contains(compositeBlock));
    }

    @org.junit.jupiter.api.Test
    void count() {
        assertEquals(wall.count(),2);
    }
}