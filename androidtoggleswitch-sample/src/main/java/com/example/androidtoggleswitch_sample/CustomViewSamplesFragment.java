package com.example.androidtoggleswitch_sample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtoggleswitch_sample.databinding.FragmentCustomViewSamplesBinding;

import org.jetbrains.annotations.NotNull;

import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import belka.us.androidtoggleswitch.widgets.ToggleSwitchButton;

/**
 * Created by rigatol on 23/06/2017.
 */

public class CustomViewSamplesFragment extends BaseSamplesFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCustomViewSamplesBinding binding = FragmentCustomViewSamplesBinding.inflate(inflater);

        binding.imageTextToggleSwitch.setView(R.layout.view_image_text_toggle_button, 2,
                new ToggleSwitchButton.ToggleSwitchButtonDecorator() {
                    @Override
                    public void decorate(ToggleSwitchButton toggleSwitchButton, @NotNull View view, int position) {
                        TextView textView   = (TextView) view.findViewById(R.id.text_view);
                        textView.setText(getCameraGalleryLabel(position));

                        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                        imageView.setImageDrawable(getCameraGalleryDrawable(position));
                    }
                },
        new ToggleSwitchButton.ViewDecorator() {
            @Override
            public void decorate(@NotNull View view, int position) {
                TextView textView   = (TextView) view.findViewById(R.id.text_view);
                textView.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));

                ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                imageView.setColorFilter(ContextCompat.getColor(getActivity(), android.R.color.white));
            }
        }, new ToggleSwitchButton.ViewDecorator() {
            @Override
            public void decorate(@NotNull View view, int position) {

                TextView textView   = (TextView) view.findViewById(R.id.text_view);
                textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.gray));

                ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                imageView.setColorFilter(ContextCompat.getColor(getActivity(), R.color.gray));
            }
        });

        binding.imageTextToggleSwitch.setOnChangeListener(new ToggleSwitch.OnChangeListener() {
            @Override
            public void onToggleSwitchChanged(int position) {
                String[] labels = {getCameraGalleryLabel(0), getCameraGalleryLabel(1)};
                showToggleChangeToast(labels, position);
            }
        });



        binding.arrowImagesToggleSwitch.setView(R.layout.view_images_toggle_button, 4,
                new ToggleSwitchButton.ToggleSwitchButtonDecorator() {
                    @Override
                    public void decorate(ToggleSwitchButton toggleSwitchButton, @NotNull View view, int position) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                        imageView.setImageDrawable(getArrowDrawable(position));
                    }
                },
                new ToggleSwitchButton.ViewDecorator() {
                    @Override
                    public void decorate(@NotNull View view, int position) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                        imageView.setColorFilter(ContextCompat.getColor(getActivity(), android.R.color.white));
                    }
                }, new ToggleSwitchButton.ViewDecorator() {
                    @Override
                    public void decorate(@NotNull View view, int position) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                        imageView.setColorFilter(ContextCompat.getColor(getActivity(), R.color.gray));
                    }
                });

        binding.arrowImagesToggleSwitch.setOnChangeListener(new ToggleSwitch.OnChangeListener() {
            @Override
            public void onToggleSwitchChanged(int position) {
                String[] labels = {getString(R.string.left), getString(R.string.up),
                        getString(R.string.right), getString(R.string.down)};
                showToggleChangeToast(labels, position);
            }
        });

        binding.multipleColorsToggleSwitch.setView(R.layout.view_image_left_and_text_toggle_button, 3,
            new ToggleSwitchButton.ToggleSwitchButtonDecorator() {
                @Override
                public void decorate(ToggleSwitchButton toggleSwitchButton, @NotNull View view, int position) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                    imageView.setImageDrawable(getCrudDrawable(position));
                    toggleSwitchButton.setCheckedBackgroundColor(getCrudActiveBackgroundColor(position));

                    TextView textView = (TextView) view.findViewById(R.id.text_view);
                    textView.setText(getCrudLabel(position));
                }
            },
            new ToggleSwitchButton.ViewDecorator() {
                @Override
                public void decorate(@NotNull View view, int position) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                    imageView.setColorFilter(ContextCompat.getColor(getActivity(), android.R.color.white));

                    TextView textView   = (TextView) view.findViewById(R.id.text_view);
                    textView.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));
                }
            },
            new ToggleSwitchButton.ViewDecorator() {
                @Override
                public void decorate(@NotNull View view, int position) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
                    imageView.setColorFilter(ContextCompat.getColor(getActivity(), R.color.gray));

                    TextView textView   = (TextView) view.findViewById(R.id.text_view);
                    textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.gray));
                }
            }
        );

        binding.multipleColorsToggleSwitch.setOnChangeListener(new ToggleSwitch.OnChangeListener() {
            @Override
            public void onToggleSwitchChanged(int position) {
                String[] labels = {getCrudLabel(0), getCrudLabel(1), getCrudLabel(2)};
                showToggleChangeToast(labels, position);
            }
        });


        return binding.getRoot();
    }

    private String getCameraGalleryLabel(int position) {
        switch (position) {
            case 0: return getString(R.string.camera);
            case 1: return getString(R.string.gallery);
            default: throw new RuntimeException("Unknown position");
        }
    }

    private Drawable getCameraGalleryDrawable(int position) {
        switch (position) {
            case 0: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_camera_alt_black_24dp);
            case 1: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_camera_roll_black_24dp);
            default: throw new RuntimeException("Unknown position");
        }
    }

    private Drawable getArrowDrawable(int position) {
        switch (position) {
            case 0: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_arrow_back_black_24dp);
            case 1: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_arrow_upward_black_24dp);
            case 2: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_arrow_forward_black_24dp);
            case 3: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_arrow_downward_black_24dp);
            default: throw new RuntimeException("Unknown position");
        }
    }

    private Drawable getCrudDrawable(int position) {
        switch (position) {
            case 0: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_add_black_24dp);
            case 1: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_edit_black_24dp);
            case 2: return ContextCompat.getDrawable(getActivity(), R.drawable.ic_delete_black_24dp);
            default: throw new RuntimeException("Unknown position");
        }
    }

    private String getCrudLabel(int position) {
        switch (position) {
            case 0: return getString(R.string.add);
            case 1: return getString(R.string.edit);
            case 2: return getString(R.string.delete);
            default: throw new RuntimeException("Unknown position");
        }
    }

    private int getCrudActiveBackgroundColor(int position) {
        switch (position) {
            case 0: return ContextCompat.getColor(getActivity(), R.color.green);
            case 1: return ContextCompat.getColor(getActivity(), R.color.blue);
            case 2: return ContextCompat.getColor(getActivity(), android.R.color.holo_red_dark);
            default: throw new RuntimeException("Unknown position");
        }
    }


}
