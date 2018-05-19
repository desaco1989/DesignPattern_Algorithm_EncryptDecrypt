package com.desaco.Algorithm.DataStructure.GraphStructure;

import java.util.Scanner;

/**
 * http://blog.csdn.net/liangxiamoyi/article/details/52154842
 * 
 * 邻接表存储的图
 * 
 * @author desaco
 *
 */
public class AdjacencyTableGraph {
	/** 
     * 指向顶点表的引用 
     */  
    private Vertex[] head;  
    /* 
     * 当前顶点的个数 
     */  
    private int vertexNum;  
    /** 
     * 构造方法 
     */  
    public AdjacencyTableGraph(){  
        int e,from,to,weight;  
        Scanner sc=new Scanner(System.in);  
        System.out.println("请输入顶点个数;");  
        this.vertexNum=sc.nextInt();  
        this.head=new Vertex[this.vertexNum];  
        for(int i=0;i<this.vertexNum;i++){  
            head[i]=new Vertex();  
            head[i].verName=i;  
            head[i].adjacent=null;  
        }  
        System.out.println("请输入边的个数：");  
        e=sc.nextInt();  
        System.out.println("请输入各个边的起点，终点和权值：");  
        for(int i=0;i<e;i++){  
            from=sc.nextInt();  
            to=sc.nextInt();  
            weight=sc.nextInt();  
            Edge p=new Edge();  
            p.verAdj=to;  
            p.cost=weight;  
            p.link=null;  
            Edge q=head[from].adjacent;  
            if(q==null){  
                head[from].adjacent=p;  
            }  
            else{  
                while(q.link!=null){  
                    q=q.link;  
                }  
                q.link=p;  
            }  
        }     
    }  
    /** 
     * 获得指定边的权值 
     * @param v1 顶点v1 
     * @param v2 顶点v2 
     * @return 权值 
     */  
    public int getWeight(int v1,int v2){  
        if(v1==-1||v2==-1)return -1;  
        Edge p=head[v1].adjacent;  
        while(p!=null){  
            if(p.verAdj==v2)return p.cost;  
            p=p.link;  
        }  
        return -1;  
    }  
    /** 
     * 获得v的第一个邻接顶点 
     * @param v 顶点v 
     * @return 第一个邻接顶点的序号 
     */  
    public int getFirstNeighbor(int v){  
        if(v==-1)return -1;  
        Edge p=head[v].adjacent;  
        if(p!=null)return p.verAdj;  
        else return -1;  
    }  
    /** 
     * 获得v1相对于v2的第一个顶点 
     * @param v1 顶点v1 
     * @param v2 顶点v2 
     * @return 顶点的序号 
     */  
    public int getNextNeighbor(int v1,int v2){  
        if(v1==-1||v2==-1)return -1;  
        Edge p=head[v1].adjacent;  
        while(p.verAdj!=v2&&p!=null){  
            p=p.link;  
        }  
        if(p==null)return -1;  
        p=p.link;  
        if(p==null)return -1;  
        return p.verAdj;  
    }  
    /** 
     * 图的深度优先遍历 
     */  
    public void depthFirstSearch(){  
        int[] visited=new int[this.vertexNum];  
        for(int i=0;i<this.vertexNum;i++){  
            visited[i]=0;  
        }  
        recDepthFirstSearch(0,visited);  
    }  
    /** 
     * 从顶点v出发深度优先遍历的递归算法 
     * @param v 顶点v 
     * @param visited 标识访问与否的数组 
     */  
    public void recDepthFirstSearch(int v,int[] visited){  
        System.out.print(v+" ");  
        visited[v]=1;  
        int w=this.getFirstNeighbor(v);  
        while(w!=-1){  
            if(visited[w]==0){//若w未被访问过，从w递归访问  
                recDepthFirstSearch(w, visited);  
            }  
            w=getNextNeighbor(v, w);//w为v相对w的下一个顶点  
        }  
    }  
    /** 
     * 深度优先遍历的迭代算法 
     * @param v 起始顶点v 
     */  
    public void iteDepthFirstSearch(int v){  
//        int[] visited=new int[this.vertexNum];  
//        for(int i=0;i<this.vertexNum;i++){  
//            visited[i]=0;  
//        }  
//        AStack<Integer> s=new AStack<Integer>(20);  
//        s.push(v);  
//        int w;  
//        while(!s.isEmpty()){  
//            w=s.pop();  
//            visited[w]=1;  
//            System.out.print(w+" ");  
//            int k=getFirstNeighbor(w);  
//            while(k!=-1){  
//                if(visited[k]==0)s.push(k);//没被访问过，压栈  
//                k=getNextNeighbor(w, k);  
//            }  
//        }  
    }  
    /** 
     * 广度优先遍历的迭代算法 
     * @param v 起始顶点v 
     */  
    public void broadFirstSearch(int v){  
//        int[] visited=new int[this.vertexNum];  
//        for(int i=0;i<this.vertexNum;i++){  
//            visited[i]=0;  
//        }  
//        System.out.print(v+" ");  
//        visited[v]=1;  
//        AQueue<Integer> a=new AQueue<Integer>(20);  
//        a.insert(v);  
//        while(!a.isEmpty()){  
//            int q=a.delete();  
//            int p=getFirstNeighbor(q);  
//            while(p!=-1){  
//                if(visited[p]==0){  
//                    System.out.print(p+" ");  
//                    visited[p]=1;  
//                    a.insert(p);  
//                }  
//                p=getNextNeighbor(q, p);  
//            }  
//        }  
    }  
    /** 
     * 对含有n个顶点的AOV网进行拓扑排序 
     */  
    public void topoOrder(){  
        int n=this.vertexNum;  
        int[] count=new int[n];  
        for(int i=0;i<n;i++){  
            count[i]=0;  
        }  
        for(int i=0;i<n;i++){  
            Edge p=head[i].adjacent;  
            while(p!=null){  
                count[p.verAdj]++;  
                p=p.link;  
            }  
        }  
        int top=-1;  
        for(int i=0;i<n;i++){  
            if(count[i]==0){//将入度为0 的顶点入栈  
                count[i]=top;  
                top=i;  
            }  
        }  
        for(int i=0;i<n;i++){  
            if(top==-1){  
                System.out.println("a cycle in the network");  
                return;  
            }  
            int j=top;  
            top=count[top];//弹栈  
            System.out.print(j+" ");  
            Edge p=head[j].adjacent;  
            while(p!=null){//删除与j关联的边  
                int k=p.verAdj;  
                if(--count[k]==0){//k的入度减1，若为0则k入栈  
                    count[k]=top;  
                    top=k;  
                }  
                p=p.link;  
            }  
        }  
    }  
    /** 
     * 计算关键路径 
     */  
    public void criticalPath(){  
        int i,k,e,l;  
        int n=this.vertexNum;  
        int[] ve=new int[n];//事件的最早发生时间  
        int[] vl=new int[n];//事件的最迟发生时间  
        for(i=0;i<n;i++){  
            ve[i]=0;  
        }  
        for(i=0;i<n;i++){//按拓扑顺序计算各事件允许的最早发生时间  
            Edge p=head[i].adjacent;  
            while(p!=null){  
                k=p.verAdj;  
                if(ve[i]+p.cost>ve[k])ve[k]=ve[i]+p.cost;  
                p=p.link;  
            }  
        }  
        for(i=0;i<n;i++){  
            vl[i]=ve[n-1];  
        }  
        for(i=n-2;i>=0;i--){//逆序计算事件的最迟发生时间  
            Edge p=head[i].adjacent;  
            while(p!=null){  
                k=p.verAdj;  
                if(vl[k]-p.cost<vl[i])vl[i]=vl[k]-p.cost;  
                p=p.link;  
            }  
        }  
        for(i=0;i<n;i++){//求各活动的最早开始时间和最晚开始时间  
            Edge p=head[i].adjacent;  
            while(p!=null){  
                k=p.verAdj;  
                e=ve[i];  
                l=vl[k]-p.cost;  
                if(l==e){  
                    System.out.println(i+"-"+k);  
                }  
                p=p.link;  
            }  
        }  
    }  
    /** 
     * <p>无权单源最短路径算法</p> 
     * <p>求顶点v到其他各顶点的最短路径</p> 
     * @param v 顶点v 
     */  
    public void shortestPath(int v){  
//        int u,k;  
//        Edge p;  
//        int n=this.vertexNum;  
//        int[] path=new int[n];  
//        int[] dist=new int[n];  
//        AQueue<Integer> q=new AQueue<Integer>(20);  //AQueue 
//        for(int i=0;i<n;i++){  
//            path[i]=-1;  
//            dist[i]=-1;  
//        }  
//        dist[v]=0;  
//        q.insert(v);  
//        while(!q.isEmpty()){//将u的未访问的顶点入队，修改其path和dist值  
//            u=q.delete();  
//            p=head[u].adjacent;  
//            while(p!=null){  
//                k=p.verAdj;  
//                if(dist[k]==-1){  
//                    q.insert(k);  
//                    dist[k]=dist[u]+1;  
//                    path[k]=u;  
//                }  
//                p=p.link;  
//            }  
//        }  
//        for(int i=0;i<n;i++){  
//            int w=i;  
//            StringBuffer st=new StringBuffer();  
//            st.append(i);  
//            while(path[w]!=v&&path[w]!=-1){  
//                int temp=path[w];  
//                st.append(" "+temp);  
//                w=path[w];  
//            }  
//            st.append(" "+v);  
//            st.reverse();  
//            System.out.println(v+"到"+i+"最短路径长度："+dist[i]+" "+"最短路径："+st);  
//        }  
    }  
    /** 
     * <p>解决正权单源最短路径问题的Dijkstra算法</p> 
     * <p>求从初始顶点v到其他各顶点的最短路径</p> 
     * @param v 初始顶点 
     */  
    public void dShortestPath(int v){  
        int u,k;  
        int max=1000;  
        Edge p;  
        int n=this.vertexNum;  
        int[] path=new int[n];  
        int[] dist=new int[n];  
        int[] s=new int[n];//记录i是否被访问过  
        for(int i=0;i<n;i++){  
            path[i]=-1;  
            dist[i]=max;  
            s[i]=0;  
        }  
        dist[v]=0;s[v]=1;  
        p=head[v].adjacent;  
        u=v;//u为即将访问的顶点  
        for(int j=0;j<n;j++){  
            while(p!=null){  
                k=p.verAdj;  
                if(s[k]!=1&&dist[u]+p.cost<dist[k]){  
                    dist[k]=dist[u]+p.cost;  
                    path[k]=u;  
                }  
                p=p.link;  
            }  
            //确定即将被访问的顶点u  
            int ldist=max;  
            for(int i=0;i<n;i++){  
                if(dist[i]>0&&dist[i]<ldist&&s[i]==0){  
                    ldist=dist[i];  
                    u=i;  
                }  
            }  
            s[u]=1;//访问u顶点  
            p=head[u].adjacent;  
        }  
        for(int i=0;i<n;i++){  
            int w=i;  
            StringBuffer st=new StringBuffer();  
            st.append(i);  
            while(path[w]!=v&&path[w]!=-1){  
                st.append(" "+path[w]);  
                w=path[w];  
            }  
            st.append(" "+v);  
            st.reverse();  
            System.out.println(v+"到"+i+"最短路径长度："+dist[i]+" "+"最短路径："+st);  
        }  
    }  
    //测试  
    public static void main(String[] args){  
//      测试数据  
//      7  
//      9  
//      0  1 1 1 2 5 2 3 9 2 4 6 3 4 8 4 5 7 5 0 4 6 5 3 0 6 2  
//      5  
//      6  
//      0 1 1 0 2 1 2 1 1 0 3 1 3 4 1 2 4 1   
//      9  
//      12  
//      0 1 6 0 2 4 0 3 5 1 4 1 2 4 1 2 5 1 3 5 2 4 6 9 4 7 8 5 7 4 6 8 2 7 8 4  
//      7  
//      12  
//      0 1 1 2 0 1 0 3 1 1 3 1 1 4 1 3 2 1 3 4 1 2 5 1 3 5 1 3 6 1 4 6 1 6 5 1  
//      6  
//      20  
//      0 1 12 1 0 12 0 2 5 2 0 5 1 2 5 2 1 5 0 3 8 3 0 8 1 4 20 4 1 20 2 3 6 3 2 6 2 4 10 4 2 10 2 5 8 5 2 8 3 5 4 5 3 4 4 5 9 5 4 9  
    	AdjacencyTableGraph g=new AdjacencyTableGraph();  
        System.out.println("递归深度优先遍历：");  
        g.depthFirstSearch();  
        System.out.println("迭代深度优先遍历：");  
        g.iteDepthFirstSearch(0);  
        System.out.println("广度优先遍历：");  
        g.broadFirstSearch(0);  
        AdjacencyTableGraph gl=new AdjacencyTableGraph();  
        System.out.println("拓扑排序：");  
        gl.topoOrder();  
        AdjacencyTableGraph gr=new AdjacencyTableGraph();  
        System.out.println("关键路径为：");  
        gr.criticalPath();  
        AdjacencyTableGraph gs=new AdjacencyTableGraph();  
        System.out.println("顶点0到各顶点的最短路径(无权)：");  
        gs.shortestPath(0);  
        AdjacencyTableGraph gt=new AdjacencyTableGraph();  
        gt.dShortestPath(0);  
    }  
}
