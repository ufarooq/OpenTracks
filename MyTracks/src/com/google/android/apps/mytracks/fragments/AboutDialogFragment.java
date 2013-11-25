/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.android.apps.mytracks.fragments;

import com.google.android.apps.mytracks.util.SystemUtils;
import com.google.android.maps.mytracks.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

/**
 * A DialogFragment to show information about My Tracks.
 * 
 * @author Jimmy Shih
 */
public class AboutDialogFragment extends AbstractMyTracksDialogFragment {

  /**
   * Interface for caller of this dialog fragment.
   * 
   * @author Jimmy Shih
   */
  public interface AboutCaller {

    /**
     * Called when about license is invoked.
     */
    public void onAboutLicense();
  }

  public static final String ABOUT_DIALOG_TAG = "aboutDialog";

  private AboutCaller caller;
  private FragmentActivity fragmentActivity;

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
      caller = (AboutCaller) activity;
    } catch (ClassCastException e) {
      throw new ClassCastException(
          activity.toString() + " must implement " + AboutCaller.class.getSimpleName());
    }
  }

  @Override
  protected Dialog createDialog() {  
    fragmentActivity = getActivity();
    View view = fragmentActivity.getLayoutInflater().inflate(R.layout.about, null);
    TextView aboutVersion = (TextView) view.findViewById(R.id.about_version);
    aboutVersion.setText(SystemUtils.getMyTracksVersion(fragmentActivity));
    return new AlertDialog.Builder(fragmentActivity).setNegativeButton(
        R.string.about_license, new DialogInterface.OnClickListener() {
            @Override
          public void onClick(DialogInterface dialog, int which) {
            caller.onAboutLicense();
          }
        }).setPositiveButton(R.string.generic_ok, null).setTitle(R.string.help_about).setView(view)
        .create();
  }
}