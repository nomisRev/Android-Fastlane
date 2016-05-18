module Fastlane
  module Actions
    module SharedValues
      JACOCO_FLAVOR = :JACOCO_FLAVOR
      JACOCO_BUILD_TYPE = :JACOCO_BUILD_TYPE
    end

    class JacocoGradleAction < Action
      def self.run(params)
        flavor = params[:flavor]
        build_type = params[:build_type]

        gradle_task = ["create", flavor, build_type, "UnitTestCoverageReport"].join

        Actions.lane_context[SharedValues::JACOCO_BUILD_TYPE] = build_type if build_type
        Actions.lane_context[SharedValues::JACOCO_FLAVOR] = flavor if flavor

        Fastlane::Actions::GradleAction.run(task: gradle_task)
      end

      #####################################################
      # @!group Documentation
      #####################################################

      def self.description
        "Creates JaCoCo test coverage report from data gathered from unit tests."
      end

      def self.available_options
         [
          FastlaneCore::ConfigItem.new(key: :flavor,
                                       env_name: 'FL_JACOCO_FLAVOR',
                                       description: 'The flavor that you want the task for, e.g. `MyFlavor`',
                                       optional: true,
                                       is_string: true),
          FastlaneCore::ConfigItem.new(key: :build_type,
                                       env_name: 'FL_JACOCO_BUILD_TYPE',
                                       description: 'The build type that you want the task for, e.g. `Release`',
                                       #default_value: 'Debug',
                                       is_string: true)
        ]
      end

      def self.output
        [
          ['JACOCO_FLAVOR', 'The flavor, e.g. `MyFlavor`'],
          ['JACOCO_BUILD_TYPE', 'The build type, e.g. `Release`']
        ]
      end

      def self.return_value
        'The output of running the gradle task'
      end

      def self.authors
        "nomisRev"
      end

      def self.is_supported?(platform)
        platform == :android
      end
    end
  end
end