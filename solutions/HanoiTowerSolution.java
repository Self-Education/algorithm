import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HanoiTowerSolution {
/* 
    there are there Hanoi Tower and N disk, smaller disk can only be on top of larger disk, 
    find a way to move disks from one tower to another.
    
*/
    List<Tower> collection;
    int numOfDisk;
    public HanoiTowerSolution(String[] towerNames, int n){
        this.collection = new LinkedList<Tower>();
        for(String name : towerNames){
            this.collection.add(new Tower(name));
        }
        Tower start = collection.get(0);
        for(int i = n; i >0; i--){
            start.addDisk(i);
        }
        this.numOfDisk = n;
    }
    public void startGame(){
        solution(numOfDisk, collection.get(0), collection.get(1), collection.get(2));
    }
    public void solution(int n, Tower origin, Tower buffer, Tower dest ){
        if(n == 1){
            // move the disk from origin to dest directly
            origin.directMove(dest);
            printGameStatus(collection);
            return;
        }
        solution(n - 1, origin, dest, buffer);// to expose very bottom disk
        origin.directMove(dest);
        printGameStatus(collection);
        solution(n - 1, buffer, origin, dest);

    }
    public void printGameStatus(List<Tower> collection){
        for(Tower tower: collection){
            tower.printTower();
        }
    }


    public static void main(String[] args){
        int n = 4;
        HanoiTowerSolution hanoiTower = new HanoiTowerSolution(new String[]{"A", "B", "C"}, 5);
        Printer.print("Before game starts: ");
        hanoiTower.printGameStatus(hanoiTower.collection);
        hanoiTower.startGame();


    }

}


class Tower{
    Stack<Integer> tower;
    String name;
    Tower(String name){
        this.tower = new Stack<>();
        this.name = name;
    }
    public void addDisk(int disk){
        tower.add(disk);
    }

    public void directMove(Tower dest){
        int disk = tower.pop();
        dest.addDisk(disk);
        Printer.print(String.format("move disk %s from Tower %s to Tower %s", disk,  this.name, dest.name));
    }
    public void printTower(){
        Printer.print(String.format("%s : %s", name, Arrays.toString(this.tower.toArray()) ));
    }
}

