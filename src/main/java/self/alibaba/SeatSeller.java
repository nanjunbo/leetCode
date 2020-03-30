package self.alibaba;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 电影院取票系统，每次获取的票都是离中心点最近的票
 */
public class SeatSeller {
    public static void main(String args[]){
        int rowCnt = 3;
        int colCnt = 3;
        int seatToSold = 4;
        //确定中心点
        Seat center = new Seat((rowCnt + 1)/2, (colCnt + 1)/2);
        List<Seat> seats = new ArrayList<Seat>();
        //计算每个点到中心点的距离
        for(int i = 1;i<= rowCnt; i++){
            for( int j = 1; j<= colCnt; j++){
                Seat s = new Seat(i,j);
                s.calDistance(center);
                seats.add(s);
            }
        }
        //排序
        Collections.sort(seats);
        for(int i= 0;i<seatToSold;i++){
            System.out.println(seats.get(i));
        }
    }
}
class Seat implements Comparable {
    private int x;
    private int y;
    private int distance;

    public Seat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void calDistance(Seat center) {
        this.distance = (center.x - this.x) * (center.x - this.x)  + (center.y - this.y) * (center.y - this.y);
    }
    @Override
    public int compareTo(Object o) {
        Seat o2 = (Seat) o;
        if (o2.distance < this.distance) {
            return 1;
        } else {
            return -1;
        }
    }
    @Override
    public String toString(){
        return String.format("(%d, %d)", this.x, this.y);
    }
}
