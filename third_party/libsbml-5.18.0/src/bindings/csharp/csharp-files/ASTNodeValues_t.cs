using System;
using System.Runtime.InteropServices;
 
//------------------------------------------------------------------------------
// <auto-generated />
//
// This file was automatically generated by SWIG (http://www.swig.org).
// Version 3.0.12
//
// Do not make changes to this file unless you know what you are doing--modify
// the SWIG interface file instead.
//------------------------------------------------------------------------------

namespace libsbmlcs {

public class ASTNodeValues_t : global::System.IDisposable {
	private HandleRef swigCPtr;
	protected bool swigCMemOwn;
	
	internal ASTNodeValues_t(IntPtr cPtr, bool cMemoryOwn)
	{
		swigCMemOwn = cMemoryOwn;
		swigCPtr    = new HandleRef(this, cPtr);
	}
	
	internal static HandleRef getCPtr(ASTNodeValues_t obj)
	{
		return (obj == null) ? new HandleRef(null, IntPtr.Zero) : obj.swigCPtr;
	}
	
	internal static HandleRef getCPtrAndDisown (ASTNodeValues_t obj)
	{
		HandleRef ptr = new HandleRef(null, IntPtr.Zero);
		
		if (obj != null)
		{
			ptr             = obj.swigCPtr;
			obj.swigCMemOwn = false;
		}
		
		return ptr;
	}

  ~ASTNodeValues_t() {
    Dispose();
  }

  public virtual void Dispose() {
    lock(this) {
      if (swigCPtr.Handle != global::System.IntPtr.Zero) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          libsbmlPINVOKE.delete_ASTNodeValues_t(swigCPtr);
        }
        swigCPtr = new global::System.Runtime.InteropServices.HandleRef(null, global::System.IntPtr.Zero);
      }
      global::System.GC.SuppressFinalize(this);
    }
  }

  public string name {
    set {
      libsbmlPINVOKE.ASTNodeValues_t_name_set(swigCPtr, value);
      if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    } 
    get {
      string ret = libsbmlPINVOKE.ASTNodeValues_t_name_get(swigCPtr);
      if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
      return ret;
    } 
  }

  public int type {
    set {
      libsbmlPINVOKE.ASTNodeValues_t_type_set(swigCPtr, value);
    } 
    get {
      int ret = libsbmlPINVOKE.ASTNodeValues_t_type_get(swigCPtr);
      return ret;
    } 
  }

  public bool isFunction {
    set {
      libsbmlPINVOKE.ASTNodeValues_t_isFunction_set(swigCPtr, value);
    } 
    get {
      bool ret = libsbmlPINVOKE.ASTNodeValues_t_isFunction_get(swigCPtr);
      return ret;
    } 
  }

  public string csymbolURL {
    set {
      libsbmlPINVOKE.ASTNodeValues_t_csymbolURL_set(swigCPtr, value);
      if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    } 
    get {
      string ret = libsbmlPINVOKE.ASTNodeValues_t_csymbolURL_get(swigCPtr);
      if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
      return ret;
    } 
  }

  public int allowedChildrenType {
    set {
      libsbmlPINVOKE.ASTNodeValues_t_allowedChildrenType_set(swigCPtr, value);
    } 
    get {
      int ret = libsbmlPINVOKE.ASTNodeValues_t_allowedChildrenType_get(swigCPtr);
      return ret;
    } 
  }

  public SWIGTYPE_p_std__vectorT_unsigned_int_t numAllowedChildren {
    set {
      libsbmlPINVOKE.ASTNodeValues_t_numAllowedChildren_set(swigCPtr, SWIGTYPE_p_std__vectorT_unsigned_int_t.getCPtr(value));
      if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
    } 
    get {
      SWIGTYPE_p_std__vectorT_unsigned_int_t ret = new SWIGTYPE_p_std__vectorT_unsigned_int_t(libsbmlPINVOKE.ASTNodeValues_t_numAllowedChildren_get(swigCPtr), true);
      if (libsbmlPINVOKE.SWIGPendingException.Pending) throw libsbmlPINVOKE.SWIGPendingException.Retrieve();
      return ret;
    } 
  }

  public ASTNodeValues_t() : this(libsbmlPINVOKE.new_ASTNodeValues_t(), true) {
  }

}

}
