/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sbml.libsbml;

/** 
 *  File and text-string SBML reader.
 <p>
 * <p style='color: #777; font-style: italic'>
This class of objects is defined by libSBML only and has no direct
equivalent in terms of SBML components.  This class is not prescribed by
the SBML specifications, although it is used to implement features
defined in SBML.
</p>

 <p>
 * The {@link SBMLReader} class provides the main interface for reading SBML content
 * from files and strings.  The methods for reading SBML all return an
 * {@link SBMLDocument} object representing the results.  In the case of failures
 * (such as if the SBML contains errors or a file cannot be read), the errors
 * will be recorded with the {@link SBMLErrorLog} object kept in the {@link SBMLDocument}
 * returned by {@link SBMLReader}.  Consequently, immediately after calling a method
 * on {@link SBMLReader}, callers should always check for errors and warnings using
 * the methods for this purpose provided by {@link SBMLDocument}.
 <p>
 * For convenience as well as easy access from other languages besides C++,
 * this file also defines two global functions,
 * @sbmlglobalfunction{readSBML, String}global and
 * @sbmlglobalfunction{readSBMLFromString, String}global.  They are
 * equivalent to creating an {@link SBMLReader} object and then calling the
 * {@link SBMLReader#readSBML(String)} and
 * {@link SBMLReader#readSBMLFromString(String)} methods, respectively.
 <p>
 * <h2>Support for reading compressed files</h2>
 <p>
 * LibSBML provides support for reading (as well as writing) compressed
 * SBML files.  The process is transparent to the calling
 * application&mdash;the application does not need to do anything
 * deliberate to invoke the functionality.  If a given SBML filename ends
 * with an extension for the <em>gzip</em>, <em>zip</em> or <em>bzip2</em> compression
 * formats (respectively, <code>.gz</code>, <code>.zip</code>, or <code>.bz2</code>), then the methods
 * @link {@link SBMLReader#readSBML(String)} {@link SBMLReader}.readSBML(String)@endlink and
 * @link {@link SBMLWriter#writeSBML(String)} {@link SBMLWriter}.writeSBML(String)@endlink
 * will automatically decompress and compress the file while reading and
 * writing it.  If the filename has no such extension, it will be read and
 * written uncompressed as normal.
 <p>
 * The compression feature requires that the <em>zlib</em> (for <em>gzip</em> and 
 * <em>zip</em> formats) and/or <em>bzip2</em> (for <em>bzip2</em> format) be available on the
 * system running libSBML, and that libSBML was configured with their
 * support compiled-in.  Please see the libSBML
 * <a href='../../../libsbml-installation.html'>installation instructions</a> 
 * for more information about this.  The methods
 * {@link SBMLReader#hasZlib()} and
 * {@link SBMLReader#hasBzip2()}
 * can be used by an application to query at run-time whether support
 * for the compression libraries is available in the present copy of
 * libSBML.
 <p>
 * Support for compression is not mandated by the SBML standard, but
 * applications may find it helpful, particularly when large SBML models
 * are being communicated across data links of limited bandwidth.
 */

public class SBMLReader {
   private long swigCPtr;
   protected boolean swigCMemOwn;

   protected SBMLReader(long cPtr, boolean cMemoryOwn)
   {
     swigCMemOwn = cMemoryOwn;
     swigCPtr    = cPtr;
   }

   protected static long getCPtr(SBMLReader obj)
   {
     return (obj == null) ? 0 : obj.swigCPtr;
   }

   protected static long getCPtrAndDisown (SBMLReader obj)
   {
     long ptr = 0;

     if (obj != null)
     {
       ptr             = obj.swigCPtr;
       obj.swigCMemOwn = false;
     }

     return ptr;
   }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libsbmlJNI.delete_SBMLReader(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  /**
   * Equality comparison method for SBMLReader.
   * <p>
   * Because the Java methods for libSBML are actually wrappers around code
   * implemented in C++ and C, certain operations will not behave as
   * expected.  Equality comparison is one such case.  An instance of a
   * libSBML object class is actually a <em>proxy object</em>
   * wrapping the real underlying C/C++ object.  The normal <code>==</code>
   * equality operator in Java will <em>only compare the Java proxy objects</em>,
   * not the underlying native object.  The result is almost never what you
   * want in practical situations.  Unfortunately, Java does not provide a
   * way to override <code>==</code>.
   *  <p>
   * The alternative that must be followed is to use the
   * <code>equals()</code> method.  The <code>equals</code> method on this
   * class overrides the default java.lang.Object one, and performs an
   * intelligent comparison of instances of objects of this class.  The
   * result is an assessment of whether two libSBML Java objects are truly 
   * the same underlying native-code objects.
   *  <p>
   * The use of this method in practice is the same as the use of any other
   * Java <code>equals</code> method.  For example,
   * <em>a</em><code>.equals(</code><em>b</em><code>)</code> returns
   * <code>true</code> if <em>a</em> and <em>b</em> are references to the
   * same underlying object.
   *
   * @param sb a reference to an object to which the current object
   * instance will be compared
   *
   * @return <code>true</code> if <code>sb</code> refers to the same underlying 
   * native object as this one, <code>false</code> otherwise
   */
  public boolean equals(Object sb)
  {
    if ( this == sb ) 
    {
      return true;
    }
    return swigCPtr == getCPtr((SBMLReader)(sb));
  }

  /**
   * Returns a hashcode for this SBMLReader object.
   *
   * @return a hash code usable by Java methods that need them.
   */
  public int hashCode()
  {
    return (int)(swigCPtr^(swigCPtr>>>32));
  }

  
/**
   * Creates a new {@link SBMLReader} object and returns it.
   <p>
   * The libSBML {@link SBMLReader} object offers methods for reading SBML in
   * XML form from files and text strings.
   */ public
 SBMLReader() {
    this(libsbmlJNI.new_SBMLReader(), true);
  }

  
/**
   * <p>
 * Reads an SBML document from the given file.
 <p>
 * If the file named <code>filename</code> does not exist or its content is not valid
 * SBML, one or more errors will be logged with the {@link SBMLDocument} object
 * returned by this method.  Callers can use the methods on {@link SBMLDocument} such
 * as
 * ,
 * {@link SBMLDocument#getNumErrors()}
 * and
 <p>
 * {@link SBMLDocument#getError(long)}
 <p>
 * to get the errors.  The object returned by
 <p>
 * {@link SBMLDocument#getError(long)}
 <p>
 * is an {@link SBMLError} object, and it has methods to get the error code,
 * category, and severity level of the problem, as well as a textual
 * description of the problem.  The possible severity levels range from
 * informational messages to fatal errors; see the documentation for
 * {@link SBMLError}
 * for more information.
 <p>
 * If the file <code>filename</code> could not be read, the file-reading error will
 * appear first.  The error code  can provide a clue about what
 * happened.  For example, a file might be unreadable (either because it does
 * not actually exist or because the user does not have the necessary access
 * privileges to read it) or some sort of file operation error may have been
 * reported by the underlying operating system.  Callers can check for these
 * situations using a program fragment such as the following:
 <p>
<pre class='fragment'>
{@link SBMLReader} reader = new {@link SBMLReader}();
{@link SBMLDocument} doc  = reader.readSBMLFromFile(filename);

if (doc.getNumErrors() &gt; 0)
{
    if (doc.getError(0).getErrorId() == libsbmlConstants.XMLFileUnreadable)
    {
        // Handle case of unreadable file here.
    }
    else if (doc.getError(0).getErrorId() == libsbmlConstants.XMLFileOperationError)
    {
        // Handle case of other file operation error here.
    }
    else
    {
        // Handle other error cases.
    }
}
</pre>
<p>
 * <p>
 * If the given filename ends with the suffix <code>'.gz'</code> (for example,
 * <code>'myfile.xml.gz'</code>), the file is assumed to be compressed in <em>gzip</em>
 * format and will be automatically decompressed upon reading.
 * Similarly, if the given filename ends with <code>'.zip'</code> or <code>'.bz2'</code>, the
 * file is assumed to be compressed in <em>zip</em> or <em>bzip2</em> format
 * (respectively).  Files whose names lack these suffixes will be read
 * uncompressed.  Note that if the file is in <em>zip</em> format but the
 * archive contains more than one file, only the first file in the
 * archive will be read and the rest ignored.
 <p>
 * <p>
 * To read a gzip/zip file, libSBML needs to be configured and linked with the
 * <a target='_blank' href='http://www.zlib.net/'>zlib</a> library at compile
 * time.  It also needs to be linked with the <a target='_blank'
 * href=''>bzip2</a> library to read files in <em>bzip2</em> format.  (Both of
 * these are the default configurations for libSBML.)  Errors about unreadable
 * files will be logged if a compressed filename is given and libSBML was
 * <em>not</em> linked with the corresponding required library.
   <p>
   * This method is identical to
   * @link {@link SBMLReader#readSBMLFromFile(String)} {@link SBMLReader}.readSBMLFromFile(String)@endlink.
   <p>
   * @param filename the name or full pathname of the file to be read.
   <p>
   * @return a pointer to the {@link SBMLDocument} object created from the SBML
   * content in <code>filename</code>.
   <p>
   * <p>
 * @note LibSBML versions 2.x and later versions behave differently in
 * error handling in several respects.  One difference is how early some
 * errors are caught and whether libSBML continues processing a file in
 * the face of some early errors.  In general, libSBML versions after 2.x
 * stop parsing SBML inputs sooner than libSBML version 2.x in the face
 * of XML errors, because the errors may invalidate any further SBML
 * content.  For example, a missing XML declaration at the beginning of
 * the file was ignored by libSBML 2.x but in version 3.x and later, it
 * will cause libSBML to stop parsing the rest of the input altogether.
 * While this behavior may seem more severe and intolerant, it was
 * necessary in order to provide uniform behavior regardless of which
 * underlying XML parser (Expat, Xerces, libxml2) is being used by
 * libSBML.  The XML parsers themselves behave differently in their error
 * reporting, and sometimes libSBML has to resort to the lowest common
 * denominator.
   <p>
   * @see #readSBMLFromString(String)
   * @see SBMLError
   * @see SBMLDocument
   */ public
 SBMLDocument readSBML(String filename) {
    long cPtr = libsbmlJNI.SBMLReader_readSBML(swigCPtr, this, libsbml.getAbsolutePath(filename));
    return (cPtr == 0) ? null : new SBMLDocument(cPtr, true);
  }

  
/**
   * <p>
 * Reads an SBML document from the given file.
 <p>
 * If the file named <code>filename</code> does not exist or its content is not valid
 * SBML, one or more errors will be logged with the {@link SBMLDocument} object
 * returned by this method.  Callers can use the methods on {@link SBMLDocument} such
 * as
 * ,
 * {@link SBMLDocument#getNumErrors()}
 * and
 <p>
 * {@link SBMLDocument#getError(long)}
 <p>
 * to get the errors.  The object returned by
 <p>
 * {@link SBMLDocument#getError(long)}
 <p>
 * is an {@link SBMLError} object, and it has methods to get the error code,
 * category, and severity level of the problem, as well as a textual
 * description of the problem.  The possible severity levels range from
 * informational messages to fatal errors; see the documentation for
 * {@link SBMLError}
 * for more information.
 <p>
 * If the file <code>filename</code> could not be read, the file-reading error will
 * appear first.  The error code  can provide a clue about what
 * happened.  For example, a file might be unreadable (either because it does
 * not actually exist or because the user does not have the necessary access
 * privileges to read it) or some sort of file operation error may have been
 * reported by the underlying operating system.  Callers can check for these
 * situations using a program fragment such as the following:
 <p>
<pre class='fragment'>
{@link SBMLReader} reader = new {@link SBMLReader}();
{@link SBMLDocument} doc  = reader.readSBMLFromFile(filename);

if (doc.getNumErrors() &gt; 0)
{
    if (doc.getError(0).getErrorId() == libsbmlConstants.XMLFileUnreadable)
    {
        // Handle case of unreadable file here.
    }
    else if (doc.getError(0).getErrorId() == libsbmlConstants.XMLFileOperationError)
    {
        // Handle case of other file operation error here.
    }
    else
    {
        // Handle other error cases.
    }
}
</pre>
<p>
 * <p>
 * If the given filename ends with the suffix <code>'.gz'</code> (for example,
 * <code>'myfile.xml.gz'</code>), the file is assumed to be compressed in <em>gzip</em>
 * format and will be automatically decompressed upon reading.
 * Similarly, if the given filename ends with <code>'.zip'</code> or <code>'.bz2'</code>, the
 * file is assumed to be compressed in <em>zip</em> or <em>bzip2</em> format
 * (respectively).  Files whose names lack these suffixes will be read
 * uncompressed.  Note that if the file is in <em>zip</em> format but the
 * archive contains more than one file, only the first file in the
 * archive will be read and the rest ignored.
 <p>
 * <p>
 * To read a gzip/zip file, libSBML needs to be configured and linked with the
 * <a target='_blank' href='http://www.zlib.net/'>zlib</a> library at compile
 * time.  It also needs to be linked with the <a target='_blank'
 * href=''>bzip2</a> library to read files in <em>bzip2</em> format.  (Both of
 * these are the default configurations for libSBML.)  Errors about unreadable
 * files will be logged if a compressed filename is given and libSBML was
 * <em>not</em> linked with the corresponding required library.
   <p>
   * This method is identical to
   * @link {@link SBMLReader#readSBML(String)} {@link SBMLReader}.readSBML(String)@endlink.
   <p>
   * @param filename the name or full pathname of the file to be read.
   <p>
   * @return a pointer to the {@link SBMLDocument} object created from the SBML
   * content in <code>filename</code>.
   <p>
   * <p>
 * @note LibSBML versions 2.x and later versions behave differently in
 * error handling in several respects.  One difference is how early some
 * errors are caught and whether libSBML continues processing a file in
 * the face of some early errors.  In general, libSBML versions after 2.x
 * stop parsing SBML inputs sooner than libSBML version 2.x in the face
 * of XML errors, because the errors may invalidate any further SBML
 * content.  For example, a missing XML declaration at the beginning of
 * the file was ignored by libSBML 2.x but in version 3.x and later, it
 * will cause libSBML to stop parsing the rest of the input altogether.
 * While this behavior may seem more severe and intolerant, it was
 * necessary in order to provide uniform behavior regardless of which
 * underlying XML parser (Expat, Xerces, libxml2) is being used by
 * libSBML.  The XML parsers themselves behave differently in their error
 * reporting, and sometimes libSBML has to resort to the lowest common
 * denominator.
   <p>
   * @see #readSBMLFromString(String)
   * @see SBMLError
   * @see SBMLDocument
   */ public
 SBMLDocument readSBMLFromFile(String filename) {
    long cPtr = libsbmlJNI.SBMLReader_readSBMLFromFile(swigCPtr, this, libsbml.getAbsolutePath(filename));
    return (cPtr == 0) ? null : new SBMLDocument(cPtr, true);
  }

  
/**
   * <p>
 * Reads an SBML document from a text string.
 <p>
 * This method is flexible with respect to the presence of an XML
 * declaration at the beginning of the string.  In particular, if the
 * string in <code>xml</code> does not begin with the XML declaration
 * <pre class='fragment'>
&lt;?xml version='1.0' encoding='UTF-8'?&gt;
</pre>
 * then this method will automatically prepend the declaration
 * to <code>xml</code>.
 <p>
 * This method will log a fatal error if the content given in the parameter
 * <code>xml</code> is not in SBML format.  See the method documentation for
 * {@link SBMLReader#readSBML()}
 <p>
 * for an example of code for testing the returned error code.
   <p>
   * @param xml a string containing a full SBML model.
   <p>
   * @return a pointer to the {@link SBMLDocument} created from the SBML content,
   * or a null pointer if <code>xml</code> is <code>null.</code>
   <p>
   * <p>
 * @note When using this method to read an {@link SBMLDocument} that uses the SBML
 * Level&nbsp;3 Hierarchical Model Composition package (comp) the document
 * location cannot be set automatically. Thus, if the model contains
 * references to ExternalModelDefinition objects, it will be necessary to
 * manually set the document URI location
 * ({@link SBMLDocument#setLocationURI()}
 <p>
 * ) in order to facilitate resolving these models.
   <p>
   * @see SBMLReader#readSBML(String)
   */ public
 SBMLDocument readSBMLFromString(String xml) {
    long cPtr = libsbmlJNI.SBMLReader_readSBMLFromString(swigCPtr, this, xml);
    return (cPtr == 0) ? null : new SBMLDocument(cPtr, true);
  }

  
/**
   * Static method; returns <code>true</code> if this copy of libSBML supports
   * <i>gzip</I> and <i>zip</i> format compression.
   <p>
   * @return <code>true</code> if libSBML has been linked with the <i>zlib</i>
   * library, <code>false</code> otherwise.
   <p>
   * 
   <p>
   * @see SBMLReader#hasBzip2()
   */ public
 static boolean hasZlib() {
    return libsbmlJNI.SBMLReader_hasZlib();
  }

  
/**
   * Static method; returns <code>true</code> if this copy of libSBML supports
   * <i>bzip2</i> format compression.
   <p>
   * @return <code>true</code> if libSBML is linked with the <i>bzip2</i>
   * libraries, <code>false</code> otherwise.
   <p>
   * 
   <p>
   * @see SBMLReader#hasZlib()
   */ public
 static boolean hasBzip2() {
    return libsbmlJNI.SBMLReader_hasBzip2();
  }

}
