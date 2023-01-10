package java07hashtable;

//Practice2
//해시 충돌 해결 - 개방 주소법(선형 탐사법)

class MyHashTable2 extends MyHashTable{
    MyHashTable2(int size){
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("Hash table is full");
            return;
        } else if (this.table[idx] == null ) { //공간 남아있는데 테이블 내 데이터가 널이라면(데이터가 할당되지 않음)
            this.table[idx] = data;
        }else{ //이미 데이터가 들어있음
            int newIdx = idx;
            while (true){
                newIdx = (newIdx + 1) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elemCnt++;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        //TestCode
        MyHashTable2 ht = new MyHashTable2(5);
        ht.setValue(1,1);
        ht.setValue(3,3);
        ht.printHashTable();

        ht.setValue(1,10);
        ht.printHashTable();

        ht.setValue(1,20);
        ht.setValue(1,30);
        ht.setValue(1,40);
        ht.printHashTable();
    }
}
