package molefarm.pattern.iterator.conc;

import molefarm.common.MoleFarmBlock;
import molefarm.pattern.iterator.Iterator;

import java.util.List;

/**
 * 农田类迭代器
 */
public class FarmIterator implements Iterator {

    private List<MoleFarmBlock> farmBlockList;
    private int index = 0;

    public FarmIterator(List<MoleFarmBlock> list) {
        this.farmBlockList = list;
    }

    @Override
    public MoleFarmBlock first() {
        return farmBlockList.get(0);
    }

    @Override
    public MoleFarmBlock next() {
        MoleFarmBlock block = null;
        if (this.hasNext()) {
            block = farmBlockList.get(index++);
        }
        return block;
    }

    @Override
    public boolean hasNext() {
        return index < farmBlockList.size();
    }

    public MoleFarmBlock getByIndex(int index_) {
        if (index_ < 0 || index_ >= farmBlockList.size()) {
            throw new IndexOutOfBoundsException("索引超出范围！");
        } else {
            this.index = index_;
            System.out.println("\n农田块" + (index+1) + "：");
            return farmBlockList.get(index);
        }
    }
}
