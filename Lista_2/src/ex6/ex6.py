class Teclado():
    """
    Classe Modeladora de teclados
    """
    def __init__(self, marca, padrao, cor):
        self.marca = marca
        self.padrao = padrao
        self.cor = cor
        
    
    def __str__(self):
        return f'{self.marca}, {self.padrao}, {self.cor}'

teclado = Teclado("corsair", "ABNT", "PRETO")
teclado2 = Teclado("razer", "ABNT", "BRANCO")


print(teclado)
print(teclado2)