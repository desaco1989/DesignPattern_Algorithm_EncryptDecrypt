//package DataStructure.StringMatchStructure;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//
//public class SparseMatrix {
//	public static void main(String[] args) {  
//        int[][] a = { { 0, 12, 9, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0 },  
//                { -3, 0, 0, 0, 0, 14, 0 }, { 0, 0, 24, 0, 0, 0, 0 },  
//                { 0, 18, 0, 0, 0, 0, 0 }, { 15, 0, 0, -7, 0, 0, 0 } };  
//  
//        System.out.println("稀疏矩阵转换成三元组顺序表：");  
//        LinkedList<?> list = constructTripleList(a);  
//        printTripleList(list);  
//          
//        System.out.println("输出对应第2行的元素");  
//        restoreArray(list, 2);  
//          
//        System.out.println("三元组顺序表还原成稀疏矩阵：");  
//        reverseToSparseMatrix(list);  
//  
//    }  
//  
//    /** 
//     * 根据行号还原顺序表中的某一行 
//     *  
//     * @param list 
//     * @param rowIndex 
//     * @return 
//     */  
//    public static float[] restoreArray(LinkedList<?> list, int rowIndex) {  
//        float[] array = new float[7];  
//        Triple t = null;  
//        int index = 0;  
//        for (int i = 0; i < list.size(); i++) {  
//            t = (Triple) list.get(i);  
//            if (t.getRowIndex() == rowIndex) {  
//                index = t.getColIndex();  
//                array[index] = t.getValue();  
//            } else {  
//                // array[index]=0;  
//            }  
//            if (t.getRowIndex() > rowIndex) {  
//                break;  
//            }  
//        }// for_i  
//          
//        for(int i = 0; i < array.length; i++){  
//            System.out.print(array[i] + " ");  
//        }  
//        System.out.println();  
//        return array;  
//    }  
//  
//    /** 
//     * 构造三元组顺序表 
//     *  
//     * @param matrix 
//     * @return 
//     */  
//    public static LinkedList<Triple> constructTripleList(int[][] matrix) {  
//        Triple e = null;  
//        LinkedList<Triple> list = new LinkedList<Triple>();  
//        for (int i = 0; i < matrix.length; i++) {  
//            for (int j = 0; j < matrix[0].length; j++)  
//                if (matrix[i][j] != 0) {  
//                    e = new Triple(i, j, matrix[i][j]);  
//                    list.add(e);  
//                }  
//        }  
//  
//        return list;  
//    }  
//  
//    /** 
//     * 将三元组顺序表转换成矩阵并输出 
//     *  
//     * @param list 
//     */  
//    public static void reverseToSparseMatrix(List<?> list) {  
//        Triple t = null;  
//        float[][] a = new float[6][7];  
//        int index = 0;  
//        for (int i = 0; i < 6; i++) {  
//            for (int j = 0; j < 7; j++) {  
//                if (index < list.size()) {  
//                    t = (Triple) list.get(index);  
//                    if (t.getRowIndex() == i) {  
//                        // 肯定是存在t.getColIndex() == j的情况  
//                        if (j == t.getColIndex()) {  
//                            a[i][j] = t.getValue();  
//                            index++;  
//                            j = t.getColIndex();  
//                        } else if (j > t.getColIndex()) {  
//                            j = 0;  
//                        }  
//                    }  
//                }  
//                // 以下注释部分会存在j>t.getColIndex，而t.getColIndex的确有值的情况，若按照以下操作取值，则会丢掉前面描述的情况的值  
//                // if((t.getRowIndex()==i) && (t.getColIndex() == j)){  
//                // a[i][j] = t.getValue();  
//                // index++;  
//                // }  
//            }// for_j  
//        }// for_i  
//  
//        for (int i = 0; i < 6; i++) {  
//            for (int j = 0; j < 7; j++) {  
//                System.out.print(a[i][j] + " ");  
//            }  
//            System.out.println();  
//        }  
//    }  
//  
//    /** 
//     * 输出稀疏矩阵 
//     *  
//     * @param matrix 
//     */  
//    public static void printSparseMatrix(int[][] matrix) {  
//        for (int i = 0; i < matrix.length; i++) {  
//            for (int j = 0; j < matrix[0].length; j++)  
//                System.out.print(matrix[i][j] + " ");  
//            System.out.println();  
//        }  
//    }  
//  
//    /** 
//     * 输出三元组顺序表 
//     *  
//     * @param list 
//     */  
//    public static void printTripleList(List<?> list) {  
//        Triple e = null;  
//        Iterator<?> iter = list.iterator();  
//        while (iter.hasNext()) {  
//            e = (Triple) iter.next();  
//            System.out.println((e.rowIndex + 1) + " " + (e.colIndex + 1) + " "  
//                    + e.value);  
//        }  
//    }  
//}

//public class Triple {
//	int rowIndex;//非零元的行下标  
//    int colIndex;//非零元的列下标  
//    int value;//非零元的值  
//      
//    Triple(){  
//        this.rowIndex = 0;  
//        this.colIndex = 0;  
//        this.value = 0;  
//    }  
//      
//    Triple(int i, int j, int value){  
//        this.rowIndex = i;  
//        this.colIndex = j;  
//        this.value = value;  
//    } 
//}
