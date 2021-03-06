/*
 * Copyright (C) 2019 Twilio, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twilio.video.app.ui.room;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.twilio.video.app.databinding.ParticipantPrimaryViewBinding;

public class ParticipantPrimaryView extends ParticipantView {
    private ParticipantPrimaryViewBinding binding;

    public ParticipantPrimaryView(Context context) {
        super(context);
        init(context);
    }

    public ParticipantPrimaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ParticipantPrimaryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ParticipantPrimaryView(
            Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void showIdentityBadge(boolean show) {
        if (binding.videoIdentity != null) {
            binding.videoIdentity.setVisibility(show ? VISIBLE : GONE);
        }
    }

    private void init(Context context) {
        binding = ParticipantPrimaryViewBinding.inflate(LayoutInflater.from(context), this, true);
        videoLayout = binding.videoLayout;
        videoIdentity = binding.videoIdentity;
        videoView = binding.video;
        selectedLayout = binding.selectedLayout;
        stubImage = binding.stub;
        selectedIdentity = binding.selectedIdentity;
        setIdentity(identity);
        setState(state);
        setMirror(mirror);
        setScaleType(scaleType);
    }
}
