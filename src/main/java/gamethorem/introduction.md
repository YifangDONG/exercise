## Zermelo's theorem (game theory)  
If a game match the following conditions:  
1. 双人、回合制
2. 信息完全公开（perfect information）
3. 无随机因素（deterministic）
4. 必然在有限步内结束；
5. 没有平局  

则游戏中的任何一个状态，要么先手有必胜策略（胜态），要么后手有必胜策略（败态）  
ex:
1. flip game, 初始时有一个由加号（“+”）组成的字符串，例如“++++++”。游戏双方轮流进行如下操作：选取相邻的两个加号，把它们变成减号。若轮到某一方时，字符串中不再有相邻的两个加号，则这一方输掉游戏。  
2. https://www.math.ucla.edu/~tom/Games/dawson.html 初始时有一个一维棋盘；游戏双方轮流下子，要求新下的棋子不能与已有的棋子相邻；无处下子者判负
3. https://en.wikipedia.org/wiki/Nim


## Sprague–Grundy theorem  
https://cp-algorithms.com/game_theory/sprague-grundy-nim.html  
https://cp-wiki.vercel.app/miscellaneous/sprague-grundy/#%E5%85%AC%E5%B9%B3%E5%8D%9A%E5%BC%88
https://zhuanlan.zhihu.com/p/20611132

胜态和败态的关键性质：经过一步行动，败态只能变成胜态，胜态可以（但不一定）变成败态。  

败态+败态 = 败态  
胜态+败态 = 胜态  
胜态+胜态 = any  
两个同级胜态的组合是败态，两个不同级胜态的组合是胜态  
