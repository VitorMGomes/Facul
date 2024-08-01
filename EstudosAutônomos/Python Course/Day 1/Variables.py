nome = input("Digite seu nome: ") #valor e atribuido no input do telcado
print(nome)

nome = 19 #aqui ele automaticamente muda o numero para um int

num1 = 2

length = len(nome)

print(len(nome))
print(nome + num1)

#########################################################################################

# nome = input("Digite um numero: ") #valor e atribuido no input do telcado 
# print(nome)

# num1 = 2

# print(nome + num1) #erro pois o numero foi inputado como str, mesmo se digitado um numnero

#########################################################################################

nome = input("Digite um numero: ") #valor e atribuido no input do telcado
nome = int(nome) #transforma a entrada de string para int, desde que seja entrado no formato int

#se eu inputar "Vitor", por exemplo, sera erro

print(nome)

num1 = 2

print(nome + num1)# efetua a soma entre dois ints




