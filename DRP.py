


class Dihedral_Element():
    
    def __init__(self, num_ab, order):
        self.order = order

        self.num_ab = num_ab
        
    def __mul__(elem1, elem2):
        assert elem1.order == elem2.order
        new_num_ab = 0
        if elem1.num_ab % 2 == 0:
            new_num_ab  = (elem1.num_ab + elem2.num_ab) % elem1.order
        else:
            new_num_ab = (elem1.num_ab - elem2.num_ab) % elem2.order

    def __str__(self):
        return 'd' + self.num_ab  
        return Dihedral_Element(new_num_ab, order)
    def __eq__(elem1, elem2):
        assert elem1.order == elem2.order
        if elem1.num_ab == elem2.num_ab:
            return True
        else:
            return False

class Z_mod_n():
    def __init__(self, number, order):
        self.number = number
        self.order = order
    def __mul__(elem1, elem2):
        assert elem1.order == elem2.order
        return Z_mod_n((elem1.number + elem2.number) % elem1.order, elem1.order)
    def __str__(self):
        return self.number
    def __eq__(elem1, elem2):
        assert elem1.order == elem2.order
        if elem1.number = elem2.number:
            return True
        return False
class Z_cross_D():

    def __init__(self, dihedral, integer):
        self.dihedral = dihedral
        self.integer = integer
    def __mul__(elem1, elem2):
        return Z_cross_D(elem1.dihedral * elem2.dihedral, elem1.integer * elem2.integer)

    def __str__(str):
        return '(' + str(self.dihedral) + ", " + str(self.integer) + ")"
    def __eq__(elem1, elem2):
        return elem1.dihedral == elem2.dihedral and elem2.integer == elem1.integer
class Group_Ring_Element():

    def __init__(self, group_elems, rings, modulo):
        assert len(rings) == len(group_elems)
        group_elems, rings = Group_Ring_Element.simplify(group_elems, rings, modulo)
        self.coefs = rings
        self.elements = group_elems
        self.modulo = modulo

    def simplify(elements, coefs, modulo):
        length = len(elements)
        while index < length:
            remove_list = []
            index2 = index + 1
            while index2 < length:
                if elements[index] == elements[index2]:
                    coefs[index] = (coefs[index] + coefs[index2]) % modulo
                    remove_list.append(index2)
                    index2 += 1
            if coefs[index] = 0:
                remove_list.add(index)
                index -= 1
            [coefs.pop(i) for i in remove_list]
            [elements.pop(i) for i in remove_list]
            length = length - len(remove_list)
            index += 1
        return (elements, coefs)
        
    def __mul__(elem1, elem2):
        





        

