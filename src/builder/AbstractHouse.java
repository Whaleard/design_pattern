package builder;

/**
 * 盖房项目需求：
 *  1、需要建房子：这一过程为打桩、砌墙、封顶。
 *  2、房子有各种各样的，比如普通房、高楼、别墅，各种房子的过程虽然一样，但是要求不要相同的。
 */
public abstract class AbstractHouse {

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
