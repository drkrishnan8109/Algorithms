package Code.Advanced;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 *
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 *
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 *
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)
 *
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
 *
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 *
 * The BFS runs at O(target * log(target)) in the worst case, with O(target * log(target))
 *
 * */
public class RaceCar
{
        class CarInfo{
            int pos, speed;
            public CarInfo(int p, int s) {
                pos = p;
                speed = s;
            }
        }
        public int racecar(int target) {
            Set<String> visited = new HashSet<>();
            String begin = 0 + "/" + 1;
            visited.add(begin);
            Queue<CarInfo> queue = new LinkedList<>();
            queue.add(new CarInfo(0,1));
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                //The reason why we have for loop inside while is to keep track of level or the steps taken
                for(int i = 0; i < size; i++) {
                    CarInfo cur = queue.poll();
                    if (cur.pos == target) return level;
                    String s1 = (cur.pos + cur.speed) + "/" + (cur.speed * 2);
                    String s2 = cur.pos + "/" + (cur.speed > 0 ? -1 : 1);
                    //Limit TLE using this condition expecting 2*target is the maximum distance we can go so that we can get back to target
                    if (Math.abs(cur.pos + cur.speed - target) < target && !visited.contains(s1)) {
                        visited.add(s1);
                        queue.add(new CarInfo(cur.pos + cur.speed, cur.speed * 2));
                    }
                    if (Math.abs(cur.pos - target) < target && !visited.contains(s2)) {
                        visited.add(s2);
                        queue.add(new CarInfo(cur.pos, cur.speed > 0 ? -1 : 1));
                    }
                }

                level++;
            }
            return -1;
        }

}
