#
# @file    TestModifierSpeciesReference.py
# @brief   ModifierSpeciesReference unit tests
#
# @author  Akiya Jouraku (Python conversion)
# @author  Ben Bornstein 
# 
# ====== WARNING ===== WARNING ===== WARNING ===== WARNING ===== WARNING ======
#
# DO NOT EDIT THIS FILE.
#
# This file was generated automatically by converting the file located at
# src/sbml/test/TestModifierSpeciesReference.c
# using the conversion program dev/utilities/translateTests/translateTests.pl.
# Any changes made here will be lost the next time the file is regenerated.
#
# -----------------------------------------------------------------------------
# This file is part of libSBML.  Please visit http://sbml.org for more
# information about SBML, and the latest version of libSBML.
#
# Copyright 2005-2010 California Institute of Technology.
# Copyright 2002-2005 California Institute of Technology and
#                     Japan Science and Technology Corporation.
# 
# This library is free software; you can redistribute it and/or modify it
# under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation.  A copy of the license agreement is provided
# in the file named "LICENSE.txt" included with this software distribution
# and also available online as http://sbml.org/software/libsbml/license.html
# -----------------------------------------------------------------------------

import sys
import unittest
import libsbml


class TestModifierSpeciesReference(unittest.TestCase):

  global MSR
  MSR = None

  def setUp(self):
    self.MSR = libsbml.ModifierSpeciesReference(2,4)
    if (self.MSR == None):
      pass    
    pass  

  def tearDown(self):
    _dummyList = [ self.MSR ]; _dummyList[:] = []; del _dummyList
    pass  

  def test_ModifierSpeciesReference_create(self):
    self.assert_( self.MSR.getTypeCode() == libsbml.SBML_MODIFIER_SPECIES_REFERENCE )
    self.assert_( self.MSR.getMetaId() == "" )
    self.assert_( self.MSR.getNotes() == None )
    self.assert_( self.MSR.getAnnotation() == None )
    self.assert_( self.MSR.getSpecies() == "" )
    self.assertEqual( False, self.MSR.isSetSpecies() )
    self.assertEqual( True, self.MSR.isModifier() )
    pass  

  def test_ModifierSpeciesReference_createWithNS(self):
    xmlns = libsbml.XMLNamespaces()
    xmlns.add( "http://www.sbml.org", "testsbml")
    sbmlns = libsbml.SBMLNamespaces(2,1)
    sbmlns.addNamespaces(xmlns)
    object = libsbml.ModifierSpeciesReference(sbmlns)
    self.assert_( object.getTypeCode() == libsbml.SBML_MODIFIER_SPECIES_REFERENCE )
    self.assert_( object.getMetaId() == "" )
    self.assert_( object.getNotes() == None )
    self.assert_( object.getAnnotation() == None )
    self.assert_( object.getLevel() == 2 )
    self.assert_( object.getVersion() == 1 )
    self.assert_( object.getNamespaces() != None )
    n = object.getNamespaces()
    self.assert_( n.getLength() == 2 )
    _dummyList = [ object ]; _dummyList[:] = []; del _dummyList
    pass  

  def test_ModifierSpeciesReference_free_NULL(self):
    _dummyList = [ None ]; _dummyList[:] = []; del _dummyList
    pass  

  def test_ModifierSpeciesReference_setSpecies(self):
    species =  "s1";
    self.MSR.setSpecies(species)
    s = self.MSR.getSpecies()
    self.assert_(( species == s ))
    self.assertEqual( True, self.MSR.isSetSpecies() )
    if (self.MSR.getSpecies() == species):
      pass    
    s = self.MSR.getSpecies()
    self.MSR.setSpecies(s)
    s = self.MSR.getSpecies()
    self.assert_(( species == s ))
    self.MSR.setSpecies("")
    self.assertEqual( False, self.MSR.isSetSpecies() )
    if (self.MSR.getSpecies() != None):
      pass    
    pass  

def suite():
  suite = unittest.TestSuite()
  suite.addTest(unittest.makeSuite(TestModifierSpeciesReference))

  return suite

if __name__ == "__main__":
  if unittest.TextTestRunner(verbosity=1).run(suite()).wasSuccessful() :
    sys.exit(0)
  else:
    sys.exit(1)

