#!/usr/bin/env python
# -*- coding: utf-8 -*-
from unicodedata import normalize

def remover_acentos(txt, codif='ISO-8859-1'):
    return normalize('NFKD', txt.decode(codif)).encode('ASCII','ignore')

def ler_arquivo():
    arquivo = open('cargaJunho.txt', 'r')
    texto = remover_acentos(arquivo.read())
    arquivo = open('cargaJunho.txt', 'w')
    arquivo.write(texto)
    arquivo.close()

if __name__ == '__main__':
    ler_arquivo()
