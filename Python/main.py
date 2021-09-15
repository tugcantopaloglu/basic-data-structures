import networkx as nx
from networkx import Graph
import matplotlib.pyplot as plt

G=nx.DiGraph()
#nodeların eklenmesi
G.add_node(0)
G.add_node(1)
G.add_node(2)
G.add_node(3)
G.add_node(4)
print("Nodelar:")
print(G.nodes())
#0lar
G.add_edge(0, 1,weight =5.0)
G.add_edge(0, 2,weight =3.0)
G.add_edge(0, 4,weight =2.0)
#4ler
G.add_edge(4, 1,weight =6.0)
G.add_edge(4, 2,weight =10.0)
G.add_edge(4, 3,weight =4.0)
#2ler
G.add_edge(2, 3,weight =2.0)
G.add_edge(2, 1,weight =1.0)
#1ler
G.add_edge(1, 3,weight =6.0)
G.add_edge(1, 2,weight =2.0)
#grafiksel olarak çizdiriyoruz
print("Köşeler:")
print(G.edges())
print("Shortest Path 4->1:")
print(nx.dijkstra_path(G,source = 4, target = 1))
print("Shortest Path 4->2:")
print(nx.dijkstra_path(G,source = 4, target = 2))
print("Shortest Path 4->3:")
print(nx.dijkstra_path(G,source = 4, target = 3))
print("Shortest Path 4->0 yolu yok.")
#3 düğümünü siliyoruz
G.remove_node(3)
print("Shortest Path 4->1:")
print(nx.dijkstra_path(G,source = 4, target = 1))
print("Shortest Path 4->2:")
print(nx.dijkstra_path(G,source = 4, target = 2))
print("Shortest Path 4->3 yolu yok.")
print("Shortest Path 4->0 yolu yok.")

