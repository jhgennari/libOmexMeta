/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  Registry where package extensions are registered.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * This class provides a central registry of all extensions known to libSBML.
 * Each package extension must be registered with the registry.  The registry
 * class is accessed by various classes to retrieve information about known
 * package extensions and to create additional attributes and/or elements by
 * factory objects of the package extensions.
 <p>
 * <p>
 * The package extension registry is implemented as a singleton instance of
 * {@link SBMLExtensionRegistry}.  The class provides only utility functionality;
 * implementations of SBML packages do not need to implement any subclasses or
 * methods of this class.  {@link SBMLExtensionRegistry} is useful for its facilities
 * to query the known packages, and to enable or disable packages selectively.
 */

public class SBMLExtensionRegistry {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected SBMLExtensionRegistry(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(SBMLExtensionRegistry obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (SBMLExtensionRegistry obj)
   {
     long ptr = 0;

     if (obj != null)
     {
       ptr             = obj.swigCPtr;
       obj.swigCMemOwn = false;
     }

     return ptr;
   }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        throw new UnsupportedOperationException("C++ destructor does not have public access");
      }
      swigCPtr = 0;
    }
  }

  
/**
   * Returns a singleton instance of the registry.
   <p>
   * Callers need to obtain a copy of the package extension registry before
   * they can invoke its methods.  The registry is implemented as a
   * singleton, and this is the method callers can use to get a copy of it.
   <p>
   * @return the instance of the {@link SBMLExtensionRegistry} object.
   */ public
 static SBMLExtensionRegistry getInstance() {
    return new SBMLExtensionRegistry(libsbmlJNI.SBMLExtensionRegistry_getInstance(), false);
  }

  
/**
   * Add the given {@link SBMLExtension} object to this {@link SBMLExtensionRegistry}.
   <p>
   * @param ext the {@link SBMLExtension} object to be added.
   <p>
   * <p>
 * @return integer value indicating success/failure of the
 * function.   The possible values
 * returned by this function are:
   * <ul>
   * <li> {@link libsbmlConstants#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS}
   * <li> {@link libsbmlConstants#LIBSBML_PKG_CONFLICT LIBSBML_PKG_CONFLICT}
   * <li> {@link libsbmlConstants#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE}
   * </ul>
   */ public
 int addExtension(SBMLExtension ext) {
    return libsbmlJNI.SBMLExtensionRegistry_addExtension(swigCPtr, this, SBMLExtension.getCPtr(ext), ext);
  }

  
/**
   * Returns an {@link SBMLExtension} object with the given package URI or package
   * name.
   <p>
   * @param package a string representing the URI or name of the SBML package
   * whose package extension is being sought.
   <p>
   * @return a clone of the {@link SBMLExtension} object with the given package URI
   * or name.
   <p>
   * @note The caller is responsible for freeing the object returned.  Since
   * the object is a clone, freeing it will not result in the deletion of the
   * original package extension object.
   */ public
 SBMLExtension getExtension(String arg0) {
	return libsbml.DowncastExtension(libsbmlJNI.SBMLExtensionRegistry_getExtension(swigCPtr, this, arg0), false);
}

  
/**
   * Removes SBML Level&nbsp;2 namespaces from the namespace list.
   <p>
   * @param xmlns an {@link XMLNamespaces} object listing one or more namespaces
   * to be removed.
   */ public
 void removeL2Namespaces(XMLNamespaces xmlns) {
    libsbmlJNI.SBMLExtensionRegistry_removeL2Namespaces(swigCPtr, this, XMLNamespaces.getCPtr(xmlns), xmlns);
  }

  
/**
   * Adds SBML Level&nbsp;2 namespaces to the namespace list.
   <p>
   * @param xmlns an {@link XMLNamespaces} object providing one or more namespaces to
   * be added.
   */ public
 void addL2Namespaces(XMLNamespaces xmlns) {
    libsbmlJNI.SBMLExtensionRegistry_addL2Namespaces(swigCPtr, this, XMLNamespaces.getCPtr(xmlns), xmlns);
  }

  
/**
   * Enables package extensions that support serialization to SBML annotations.
   <p>
   * SBML Level&nbsp;2 does not have a package mechanism in the way that SBML
   * Level&nbsp;3 does.  However, SBML annotations can be used to store SBML
   * constructs.  In fact, a widely-used approach to developing SBML
   * Level&nbsp;3 packages involves first using them as annotations.
   <p>
   * @param doc the {@link SBMLDocument} object for which this should be enabled.
   */ public
 void enableL2NamespaceForDocument(SBMLDocument doc) {
    libsbmlJNI.SBMLExtensionRegistry_enableL2NamespaceForDocument(swigCPtr, this, SBMLDocument.getCPtr(doc), doc);
  }

  
/**
   * Disables unused packages.
   <p>
   * This method walks through all extensions in the list of plugins of the
   * given SBML document <code>doc</code>, and disables all that are not being used.
   <p>
   * @param doc the {@link SBMLDocument} object whose unused package extensions
   * should be disabled.
   */ public
 void disableUnusedPackages(SBMLDocument doc) {
    libsbmlJNI.SBMLExtensionRegistry_disableUnusedPackages(swigCPtr, this, SBMLDocument.getCPtr(doc), doc);
  }

  
/**
   * Disables the package with the given URI or name.
   <p>
   * @param package a string representing the URI or name of the SBML package
   * whose package extension is to be disabled.
   */ public
 static void disablePackage(String arg0) {
    libsbmlJNI.SBMLExtensionRegistry_disablePackage(arg0);
  }

  
/**
   * Returns <code>true</code> if the named package is enabled.
   <p>
   * @param package the name or URI of a package to test.
   <p>
   * @return <code>true</code> if the package is enabled, <code>false</code> otherwise.
   */ public
 static boolean isPackageEnabled(String arg0) {
    return libsbmlJNI.SBMLExtensionRegistry_isPackageEnabled(arg0);
  }

  
/**
   * Enables the package with the given URI / name.
   <p>
   * @param package the name or URI of a package to enable.
   */ public
 static void enablePackage(String arg0) {
    libsbmlJNI.SBMLExtensionRegistry_enablePackage(arg0);
  }

  
/**
   * Returns the number of extensions that have a given extension point.
   <p>
   * @param extPoint the {@link SBaseExtensionPoint} object.
   <p>
   * @return the number of {@link SBMLExtension}-derived objects with the given
   * extension point.
   */ public
 long getNumExtension(SBaseExtensionPoint extPoint) {
    return libsbmlJNI.SBMLExtensionRegistry_getNumExtension(swigCPtr, this, SBaseExtensionPoint.getCPtr(extPoint), extPoint);
  }

  
/**
   * Enables or disable the package with the given URI.
   <p>
   * @param uri the URI of the target package.
   * @param isEnabled <code>true</code> to enable the package, <code>false</code> to disable.
   <p>
   * @return <code>false</code> if <code>isEnabled</code> is <code>false</code> or the given package is not
   * registered, otherwise this method returns <code>true.</code>
   */ public
 boolean setEnabled(String uri, boolean isEnabled) {
    return libsbmlJNI.SBMLExtensionRegistry_setEnabled(swigCPtr, this, uri, isEnabled);
  }

  
/**
   * Returns <code>true</code> if the given extension is enabled.
   <p>
   * @param uri the URI of the target package.
   <p>
   * @return <code>false</code> if the given package is disabled or not registered,
   * <code>true</code> otherwise.
   */ public
 boolean isEnabled(String uri) {
    return libsbmlJNI.SBMLExtensionRegistry_isEnabled(swigCPtr, this, uri);
  }

  
/**
   * Returns <code>true</code> if a package extension is registered for the
   * corresponding package URI.
   <p>
   * @param uri the URI of the target package.
   <p>
   * @return <code>true</code> if the package with the given URI is registered,
   * otherwise returns <code>false.</code>
   */ public
 boolean isRegistered(String uri) {
    return libsbmlJNI.SBMLExtensionRegistry_isRegistered(swigCPtr, this, uri);
  }

  
/**
   * Returns a list of registered packages.
   <p>
   * This method returns a vector of strings containing the nicknames of the
   * SBML packages for which package extensions are registered with this copy
   * of libSBML.  The vector will contain <code>String</code> objects.
   <p>
   * @return a vector of strings of the registered package names.
   */ public
 static SWIGTYPE_p_std__vectorT_std__string_t getAllRegisteredPackageNames() {
    return new SWIGTYPE_p_std__vectorT_std__string_t(libsbmlJNI.SBMLExtensionRegistry_getAllRegisteredPackageNames(), true);
  }

  
/**
   * Returns the number of registered packages.
   <p>
   * @return a count of the registered package extensions.
   */ public
 static long getNumRegisteredPackages() {
    return libsbmlJNI.SBMLExtensionRegistry_getNumRegisteredPackages();
  }

  
/**
   * Returns the nth registered package.
   <p>
   * @param index zero-based index of the package name to return.
   <p>
   * @return the package name with the given index, or <code>null</code> if none
   * such exists.
   <p>
   * @see #getNumRegisteredPackages()
   */ public
 static String getRegisteredPackageName(long index) {
    return libsbmlJNI.SBMLExtensionRegistry_getRegisteredPackageName(index);
  }

  
/** */ public
 SWIGTYPE_p_std__vectorT_ASTBasePlugin_p_t getASTPlugins() {
    return new SWIGTYPE_p_std__vectorT_ASTBasePlugin_p_t(libsbmlJNI.SBMLExtensionRegistry_getASTPlugins(swigCPtr, this), true);
  }

  
/** */ public
 long getNumASTPlugins() {
    return libsbmlJNI.SBMLExtensionRegistry_getNumASTPlugins(swigCPtr, this);
  }

  
/** */ public
 ASTBasePlugin getASTPlugin(long i) {
  return libsbml.DowncastASTBasePlugin(libsbmlJNI.SBMLExtensionRegistry_getASTPlugin(swigCPtr, this, i), false);
}

}
