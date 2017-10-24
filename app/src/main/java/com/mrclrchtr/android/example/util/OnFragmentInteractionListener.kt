package com.mrclrchtr.android.example.util

import android.net.Uri

/**
 * Created by Marcel Richter on 24.10.2017.
 *
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 *
 *
 * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
 */
interface OnFragmentInteractionListener {
    fun onFragmentInteraction(TAG: String, uri: Uri)
}