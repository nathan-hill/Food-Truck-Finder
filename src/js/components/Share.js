import React from "react";
import {
  TwitterShareButton,
  TwitterIcon,
  FacebookShareButton,
  FacebookIcon,
  FacebookShareCount,
  RedditIcon,
  RedditShareButton,
  RedditShareCount
} from "react-share";
import "./../styles/share.css";

var constants = require('../helpers/constants')

export const Share = (props) => {

  let TruckName = JSON.parse(props.selected).name;
  let shareUrl = constants.backend_url
  let size = 32;

  let title = "Check out this food truck I just found, " + TruckName + " !";

  console.log("props:", props.selected)
  console.log("url: ", shareUrl)

  return (
    <div>
      <div className="Demo__some-network">
        <FacebookShareButton
          url={shareUrl}
          quote={title}
          className="Demo__some-network__share-button"
        >
          <FacebookIcon size={size} round />
        </FacebookShareButton>

          <FacebookShareCount
            url={shareUrl}
            className="Demo__some-network__share-count"
          >
            {(count) => count}
          </FacebookShareCount>
      </div>
      <div className="Demo__some-network">
        <TwitterShareButton
          url={shareUrl}
          title={title}
          className="Demo__some-network__share-button"
        >
          <TwitterIcon size={size} round />
        </TwitterShareButton>
        </div>
        <div className="Demo__some-network">
          <RedditShareButton
            url={shareUrl}
            title={title}
            windowWidth={660}
            windowHeight={460}
            className="Demo__some-network__share-button"
          >
            <RedditIcon size={size} round />
          </RedditShareButton>

          <div>
            <RedditShareCount url={shareUrl} className="Demo__some-network__share-count" />
          </div>
        <div className="Demo__some-network__share-count">&nbsp;</div>
      </div>
    </div>
  );
};
