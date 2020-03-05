package de.dennisguse.opentracks.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarkerEditViewModel extends ViewModel {
    private MutableLiveData<String> waypointNameText;
    private MutableLiveData<String> waypointMarkerTypeText;
    private MutableLiveData<String> waypointDescriptionText;

    public MarkerEditViewModel() {
        waypointNameText = new MutableLiveData<>("");
        waypointMarkerTypeText = new MutableLiveData<>("");
        waypointDescriptionText = new MutableLiveData<>("");
    }

    public MutableLiveData<String> getWaypointNameText() {
        return waypointNameText;
    }

    public MutableLiveData<String> getWaypointMarkerTypeText() {
        return waypointMarkerTypeText;
    }

    public MutableLiveData<String> getWaypointDescriptionText() {
        return waypointDescriptionText;
    }
}
